package com.example.demojpa.services;

import com.example.demojpa.dtos.BookCreateRequest;
import com.example.demojpa.models.Book;
import com.example.demojpa.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public void create(BookCreateRequest bookCreateRequest) throws SQLException {

        Book book = bookCreateRequest.to();
//        this.bookRepository.create(book);

    }

    public List<Book> getAll() throws SQLException {
        return null;
//        return this.bookRepository.getAll();
    }

    public Book getById(int id) throws SQLException{
        return null;
//        return bookRepository.getById(id);
    }
}
