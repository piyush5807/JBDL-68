package com.example.minorproject1.services;

import com.example.minorproject1.dtos.GetStudentDetailsResponse;
import com.example.minorproject1.models.*;
import com.example.minorproject1.repositories.TransactionRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

@RunWith(MockitoJUnitRunner.class)
public class TransactionServiceTest {

    // 10k : are 6k lines covered by your UTs ?

    /**
     * Usually people write UTs for service classes (controller, repository etc. that doesn't contain business logic can be skipped)
     * You should write test cases not only for happy scenarios but also for edge cases or failure scenarios
     *
     * UT checks the difference b/w the expected output and the actual output
     *
     * Junit - for writing test case : @Test , Assertions are present in this library
     * Mockito - write mock classes / mock the behaviour of certain function
     *         - mocking is simulating the behaviour of underlying classes' function
     */


    @InjectMocks      // Similar to @Component - i.e the object of transaction service will be created and attached with the test class

    // Note: Don't go exactly on the words just try to compare the analogy
    TransactionService transactionService;

    @Mock // this annotation creates a dummy object of transactionRepository and attaches with transactionService
    TransactionRepository transactionRepository;

    @Mock
    StudentService studentService;

    @Mock
    BookService bookService;

    @Test
    public void testCalculateFine_PositiveFine(){

        Book book = Book.builder()
                .id(5)
                .build();

        Student student = Student.builder()
                .id(1)
                .build();

        Transaction transaction = Transaction.builder()
                .id(1)
                .student(student)
                .book(book)
                .transactionType(TransactionType.ISSUE)
                .transactionStatus(TransactionStatus.SUCCESS)
                .updatedOn(new Date(1713543590000l))
                .build();

        Mockito.when(transactionRepository.findTopByStudentAndBookAndTransactionTypeAndTransactionStatusOrderByIdDesc(
                        Mockito.eq(student),
                        Mockito.eq(book),
                        Mockito.eq(TransactionType.ISSUE),
                        Mockito.eq(TransactionStatus.SUCCESS))
                ).thenReturn(transaction);

        int fine = transactionService.calculateFine(book, student);

        Assert.assertEquals(15, fine);
    }

    @Test
    public void testCalculateFine_NoFine(){

        Book book = Book.builder()
                .id(5)
                .build();

        Student student = Student.builder()
                .id(1)
                .build();

        Transaction transaction = Transaction.builder()
                .id(1)
                .student(student)
                .book(book)
                .transactionType(TransactionType.ISSUE)
                .transactionStatus(TransactionStatus.SUCCESS)
                .updatedOn(new Date(1714925990000l))
                .build();

        Mockito.when(transactionRepository.findTopByStudentAndBookAndTransactionTypeAndTransactionStatusOrderByIdDesc(
                Mockito.eq(student),
                Mockito.eq(book),
                Mockito.eq(TransactionType.ISSUE),
                Mockito.eq(TransactionStatus.SUCCESS))
        ).thenReturn(transaction);

        int fine = transactionService.calculateFine(book, student);

        Assert.assertEquals(0, fine);
    }

//    @Test
//    public void testInitiateReturn() throws Exception{
//
//        Student student = Student.builder()
//                .id(1)
//                .build();
//
//        GetStudentDetailsResponse getStudentDetailsResponse = GetStudentDetailsResponse.builder()
//                .student(student)
//                .bookList(new ArrayList<>())
//                .build();
//
//        Mockito.when(studentService.getStudentDetails(1, true)).thenReturn(getStudentDetailsResponse);
//
//
//
//        String txnId = transactionService.initiateReturn(1, 1);
//    }

    @Test
    public void testInitiateReturn() throws Exception{

        Student student = Student.builder()
                .id(1)
                .build();

        Book book = Book.builder()
                .id(5)
                .student(student)
                .build();

        GetStudentDetailsResponse getStudentDetailsResponse = GetStudentDetailsResponse.builder()
                .student(student)
                .bookList(new ArrayList<>())
                .build();

        String externalId = UUID.randomUUID().toString();

        Transaction transaction = Transaction.builder()
                .id(1)
                .externalTransactionId(externalId)
                .student(student)
                .book(book)
                .transactionType(TransactionType.ISSUE)
                .transactionStatus(TransactionStatus.SUCCESS)
                .updatedOn(new Date(1714925990000l))
                .build();

        Mockito.when(studentService.getStudentDetails(1, true))
                .thenReturn(getStudentDetailsResponse);

        Mockito.when(bookService.getBookById(1)).thenReturn(book);

        Mockito.when(transactionRepository.save(Mockito.any())).thenReturn(transaction);

        Mockito.when(transactionRepository.findTopByStudentAndBookAndTransactionTypeAndTransactionStatusOrderByIdDesc(
                Mockito.eq(student),
                Mockito.eq(book),
                Mockito.eq(TransactionType.ISSUE),
                Mockito.eq(TransactionStatus.SUCCESS))
        ).thenReturn(transaction);

        Mockito.when(bookService.createOrUpdate(Mockito.any())).thenReturn(book);

        Mockito.when(transactionRepository.save(Mockito.any())).thenReturn(transaction);

        String txnId = transactionService.initiateReturn(1, 1);

        Assert.assertEquals(externalId, txnId);
    }

    @Test(expected = Exception.class)
    public void testInitiateReturn_StudentNotAssigned() throws Exception{

        Student student = Student.builder()
                .id(1)
                .build();

        Book book = Book.builder()
                .id(5)
//                .student(student)
                .build();

        GetStudentDetailsResponse getStudentDetailsResponse = GetStudentDetailsResponse.builder()
                .student(student)
                .bookList(new ArrayList<>())
                .build();


        Mockito.when(studentService.getStudentDetails(1, true))
                .thenReturn(getStudentDetailsResponse);

        Mockito.when(bookService.getBookById(1)).thenReturn(book);



        transactionService.initiateReturn(1, 1);

    }
}
