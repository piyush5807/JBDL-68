package com.example.minorproject1.controllers;

import com.example.minorproject1.dtos.CreateBookRequest;
import com.example.minorproject1.models.Book;
import com.example.minorproject1.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("")
    public Integer createBook(@Valid @RequestBody CreateBookRequest request){
        return bookService.create(request);
    }

    @GetMapping("/{bookId}")
    public Book getBookById(@PathVariable("bookId") Integer bookId){
        return bookService.getBookById(bookId);
    }

    /**
     * TODO: Build a simple GET /search API which is going to return results basis some
     *       search parameters and it should be a paginated API
     */

    /**
     * use case -
     * filteration + pagination
     * <= 2024
     * 1 million books
     *  all such books and then allow FE to filter on their own
     *  you are querying only some part of the entire data from the db
     */

}
