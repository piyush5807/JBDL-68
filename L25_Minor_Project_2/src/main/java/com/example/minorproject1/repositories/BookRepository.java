package com.example.minorproject1.repositories;

import com.example.minorproject1.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

//    @Query()
    List<Book> findByStudentId(int studentId);

}
