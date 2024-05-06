package com.example.minorproject1.services;

import com.example.minorproject1.dtos.GetStudentDetailsResponse;
import com.example.minorproject1.models.Book;
import com.example.minorproject1.models.Student;
import com.example.minorproject1.repositories.BookRepository;
import com.example.minorproject1.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    BookRepository bookRepository;

//    public GetStudentDetailsResponse getStudentDetails(Integer studentId, boolean requireBookList){
//        Student student = this.studentRepository.findById(studentId).orElse(null);
//        List<Book> bookList = null;
//        if(requireBookList){
//            bookList = this.bookService.getBooksByStudentId(studentId);
//        }
//        return GetStudentDetailsResponse.builder()
//                .student(student)
//                .bookList(bookList)
//                .build();
//    }

    public GetStudentDetailsResponse getStudentDetails(Integer studentId, boolean requireBookList){
        Student student = this.studentRepository.findById(studentId).orElse(null);
        List<Book> bookList = null;
        if(requireBookList){
            bookList = this.bookRepository.findByStudentId(studentId);
        }


        this.studentRepository.save(Student.builder().build());

        return GetStudentDetailsResponse.builder()
                .student(student)
                .bookList(bookList)
                .build();
    }
}
