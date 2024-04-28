package com.example.demodb.books.service;

import com.example.demodb.books.models.Book;
import com.example.demodb.books.repository.BookRepository;
import com.example.demodb.books.requests.BookCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

// MVC - MODEL VIEW CONTROLLER (SERVICE / REPOSITORY)

/**
 *
 */

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public void create(BookCreateRequest bookCreateRequest) throws SQLException {

        Book book = bookCreateRequest.to();
        this.bookRepository.create(book);

    }

    public List<Book> getAll() throws SQLException {

        return this.bookRepository.getAll();
    }

    public Book getById(int id) throws SQLException{

        return bookRepository.getById(id);
    }
}
