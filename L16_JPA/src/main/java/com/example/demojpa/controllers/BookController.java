package com.example.demojpa.controllers;


import com.example.demojpa.dtos.BookCreateRequest;
import com.example.demojpa.models.Book;
import com.example.demojpa.services.BookService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@Controller
@ResponseBody // allows the java --> json conversion
public class BookController {

    @Autowired
    BookService bookService;


    // CRUD

    @PostMapping("/book")
    public void createBook(@Valid @RequestBody BookCreateRequest bookCreateRequest) throws SQLException {
        this.bookService.create(bookCreateRequest);
    }

    @GetMapping("/book/all")
    public List<Book> getBooks() throws SQLException {
        return this.bookService.getAll();
    }

    @GetMapping(value = "/book/{id}")
    public Book getBookById(@PathVariable("id") int id) throws SQLException {
        return this.bookService.getById(id);
    }
}

