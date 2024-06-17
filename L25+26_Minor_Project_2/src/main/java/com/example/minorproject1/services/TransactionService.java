package com.example.minorproject1.services;

import com.example.minorproject1.models.*;
import com.example.minorproject1.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    StudentService studentService;

    @Autowired
    BookService bookService;

    @Value("${students.books.max-allowed}")
    Integer maxAllowedBooks;

//    @Value("${books.return.duration}")
    Integer returnDuration = 15;

//    @Value("${fine.per-day}")
    Integer finePerDay = 1;


    public String initiateTransaction(Integer studentId, Integer bookId, TransactionType transactionType) throws Exception {
        switch (transactionType){
            case ISSUE:
                return initiateIssuance(studentId, bookId);
            case RETURN:
                return initiateReturn(studentId, bookId);
            default:
                throw new Exception("Invalid transaction type");
        }
    }

    /**
     *
     * Check balance - 500 (t1 - 10:15 AM)
     *                                           ( deduct 200 from the account : )
     * Send money - 200 --> someone (t2 - 10:16 AM) :
     *     Scenario : 1. system will initiate the request to the db and it gets failed because of low balance (100)
     *                2. system will initiate the request to the db and it gets failed because of stale update / wrong version number
     *
     */

    /**
     * ------------------   Validations  -----------------------------------------
     * 1. Validate student and book, throw 400 / 404 if any of these details are invalid (v1)
     * 2. Validate whether the book is available or not
     * 3. Validate student's limit of issuance
     * -------------------------------------------------------------
     * 4. Creating transaction entry in the transaction table with status as PENDING
     *
     * 5. Make the book unavailable / assign it to student so that no one else can issue the book concurrently {book.student = ?} (data, v1 + 1 = v2)
     * 6. update the transaction entry with the status as SUCCESS
     * 7. If the update the transaction entry with status as FAILED
     */

    /**
     * Optimistic locking : one extra column that contains version number v1
     * Pessimistic locking : insert / update / delete
     */

    private String initiateIssuance(Integer studentId, Integer bookId) throws Exception {

        // -------------- Data retrieval ----------------------------------

        Student student = this.studentService.getStudentDetails(studentId, true).getStudent();
        Book book = this.bookService.getBookById(bookId);

        // --------------- Validations ------------------------------------

        if(student == null){
            throw new Exception("Student is not present");
        }


        if(book == null || book.getStudent() != null){
            throw new Exception("Book is not available for issuance");
        }

        List<Book> issuedBooks = student.getBookList();
        if(issuedBooks != null && issuedBooks.size() >= this.maxAllowedBooks){
            throw new Exception("Student has issued maximum number of books allowed");
        }

        //------------------------ Issuance logic -------------------------------

        Transaction transaction = Transaction.builder()
                .student(student)  // adding student id as a foreign key
                .book(book) // adding book id as a foreign key
                .externalTransactionId(UUID.randomUUID().toString())
                .transactionType(TransactionType.ISSUE)
                .transactionStatus(TransactionStatus.PENDING)
                .build();

        transaction = this.transactionRepository.save(transaction);

        try{
            book.setStudent(student); // joining book and student table
            book = this.bookService.createOrUpdate(book);

            transaction.setTransactionStatus(TransactionStatus.SUCCESS);
            this.transactionRepository.save(transaction);
        }catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            this.transactionRepository.save(transaction);

            if(book.getStudent() != null){
                book.setStudent(null); // removing the association from the student table for this particular record
                this.bookService.createOrUpdate(book);
            }
        }

        return transaction.getExternalTransactionId();
    }

    /**
     * ------------------   Validations  -----------------------------------------
     * 1. Validate student and book, throw 400 / 404 if any of these details are invalid (v1)
     * 2. Validate whether the book is assigned or not and if assigned it should be to that particular student only
     * -------------------------------------------------------------
     * 3. Creating transaction entry in the transaction table with status as PENDING
     *
     * 4. Make the book available / unassign it from student so that anyone else can issue the book
     * 5. update the transaction entry with the status as SUCCESS
     * 6. If the update the transaction entry with status as FAILED
     */

    public String initiateReturn(Integer studentId, Integer bookId) throws Exception{

        Student student = this.studentService.getStudentDetails(studentId, true).getStudent();
        Book book = this.bookService.getBookById(bookId);

        // --------------- Validations ------------------------------------

        if(student == null){
            throw new Exception("Student is not present");
        }

        if(book == null || book.getStudent() == null || book.getStudent().getId() != studentId){
            throw new Exception("Book is not available for return");
        }

        Transaction transaction = Transaction.builder()
                .student(student)  // adding student id as a foreign key
                .book(book) // adding book id as a foreign key
                .externalTransactionId(UUID.randomUUID().toString())
                .transactionType(TransactionType.RETURN)
                .transactionStatus(TransactionStatus.PENDING)
                .build();

        transaction = this.transactionRepository.save(transaction);

        try{
            Integer fine = this.calculateFine(book, student);
            book.setStudent(null); // un-assigning the student from that book
            book = this.bookService.createOrUpdate(book);

            transaction.setFine(fine);
            transaction.setTransactionStatus(TransactionStatus.SUCCESS);
            this.transactionRepository.save(transaction);
        }catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            this.transactionRepository.save(transaction);

            if(book.getStudent() == null){
                book.setStudent(student);
                this.bookService.createOrUpdate(book);
            }
        }

        return transaction.getExternalTransactionId();
    }

    /**
     * 1. Get the issuance txn
     * 2. Calculate the time taken from the txn updated_on time to the current time
     * @param book
     * @param student
     */

    public Integer calculateFine(Book book, Student student) {

        Transaction issuedTxn = this.transactionRepository.findTopByStudentAndBookAndTransactionTypeAndTransactionStatusOrderByIdDesc(student, book, TransactionType.ISSUE, TransactionStatus.SUCCESS);
        Long issuedTimeInMillis = issuedTxn.getUpdatedOn().getTime();
        Long timePassedInMillis = System.currentTimeMillis() - issuedTimeInMillis;

        Long daysPassed = TimeUnit.DAYS.convert(timePassedInMillis, TimeUnit.MILLISECONDS);
        if(daysPassed > returnDuration ){
            return  (daysPassed.intValue() - returnDuration) * finePerDay;
        }

        // actual time allotted for the book - 1296000000
        // 1296000001 : 15 days 16 days

        return 0;
    }

}
