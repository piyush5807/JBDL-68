package com.example.demojpa.controllers;


import com.example.demojpa.dtos.BookCreateRequest;
import com.example.demojpa.models.Book;
import com.example.demojpa.models.Genre;
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
    public Book createBook(@Valid @RequestBody BookCreateRequest bookCreateRequest) throws SQLException {
        return this.bookService.create(bookCreateRequest);
    }

    @GetMapping("/book/all")
    public List<Book> getBooks() throws SQLException {
        return this.bookService.getAll();
    }

    @GetMapping(value = "/book/{id}")
    public Book getBookById(@PathVariable("id") int id) throws SQLException {
        return this.bookService.getById(id);
    }

    /**
     * Implement an API that return all the books for a given genre
     */

    // JPQL is better because it requires minimum conversion

    @GetMapping("/book/author/{author-email}/jpql")
    public List<Book> getBooksByAuthorJPQL(@PathVariable("author-email") String authorEmail){
        return this.bookService.getByAuthorJPQL(authorEmail);
    }

    @GetMapping("/book/author/{author-email}/native")
    public List<Book> getBooksByAuthorNative(@PathVariable("author-email") String authorEmail){
        return this.bookService.getByAuthorNative(authorEmail);
    }

    @GetMapping("/book/author/{author-email}/genre/{genre}")
    public List<Book> getBooksByAuthorNative(
            @PathVariable("author-email") String authorEmail,
            @PathVariable("genre") Genre genre){

//        genre = genre.toUpperCase();
//        Genre gen = Genre.valueOf(genre);
        return this.bookService.getByAuthorEmailAndGenre(authorEmail, genre);
    }

    @GetMapping("/book/genre/{genre}")
    public List<Book> getBooksByAuthorNative(@PathVariable("genre") Genre genre){
        return this.bookService.getByGenre(genre);
    }

    @GetMapping("/book/author/{pattern}")
    public List<Book> getBooksByPattern(@PathVariable("pattern") String pattern){
        return this.bookService.getByAuthorEmailPattern("%" + pattern);
    }

    @PatchMapping("/book/{bookId}")
    public void updateGenre(
            @PathVariable("bookId") int bookId,
            @RequestParam("genre") Genre genre){
         this.bookService.updateGenre(bookId, genre);
    }

}

