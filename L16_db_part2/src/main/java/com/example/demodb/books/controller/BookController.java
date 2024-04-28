package com.example.demodb.books.controller;

import com.example.demodb.books.models.Book;
import com.example.demodb.books.requests.BookCreateRequest;
import com.example.demodb.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    // PUT / PATCH
    // DELETE


//    static int counter = 1;
//
//    public int autoIncrement(){
//        int result = counter;
//        counter += 1;
//        return result;
//    }
//
//    HashMap<Integer, Object> map = new HashMap<>();
//
//    public void insert(Object data){
//
//        if(data contains id){
//
//            if(id >= counter){
//                counter = id + 1
//            }
//        }else{
//            autoIncrement();
//        }
//    }
//
//    public void delete(Object data){
//        map.remove(data.key);
//    }
}
