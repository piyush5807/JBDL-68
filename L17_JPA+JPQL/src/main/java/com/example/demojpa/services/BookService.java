package com.example.demojpa.services;

import com.example.demojpa.dtos.BookCreateRequest;
import com.example.demojpa.models.Book;
import com.example.demojpa.models.Genre;
import com.example.demojpa.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

//    @Autowired
//    JpaRepository<Book, Integer> bookRepository;

    // Implement an API that gives all the books for a particular genre

//    @Autowired
//    SimpleJpaRepository<Book, Integer> bookRepository;


    public Book create(BookCreateRequest bookCreateRequest) throws SQLException {

        Book book = bookCreateRequest.to();
        return this.bookRepository.save(book);

    }

    public List<Book> getAll() throws SQLException {
        return this.bookRepository.findAll();

        // bean name - bookRepository , bean type - SimpleJpaRepository<Book>
        // bean name - studentRepository, bean type - SimpleJpaRepository<Student>
//        return this.bookRepository.getAll();
    }

    public Book getById(int id) {
        return this.bookRepository
                .findById(id)
                .orElse(null);
    }

    public List<Book> getByAuthorJPQL(String authorEmail) {
        return this.bookRepository.findByAuthorJPQL(authorEmail);
    }

    public List<Book> getByAuthorNative(String authorEmail) {
        return this.bookRepository.findByAuthorNative(authorEmail);
    }

    public List<Book> getByAuthorEmailAndGenre(String authorEmail, Genre genre) {
        return this.bookRepository.findByGenreOrAuthorEmail(genre, authorEmail);
    }

    public List<Book> getByGenre(Genre genre) {
        return this.bookRepository.findByGenre(genre);
    }

    public List<Book> getByAuthorEmailPattern(String pattern) {
        return this.bookRepository.findByAuthorEmailLike(pattern);
    }

    /**
     * public <S extends T> S save(S entity) {
     *         Assert.notNull(entity, "Entity must not be null.");
     *         if (this.entityInformation.isNew(entity)) {
     *             this.em.persist(entity);
     *             return entity;
     *         } else {
     *             return this.em.merge(entity);
     *         }
     *     }
     *
     *     isNew will check if id is set or not ?
     *     if id is set to some value -> merge  (update book set ..... where id = 5) throws exception
     *     else -> persist (insert into .... VALUES (.....) )
     *
     *     save -> upsert
     */

    public void updateGenre(int bookId, Genre genre) {
        Book book = this.getById(bookId);
        book.setGenre(genre);
        bookRepository.save(book);
    }

    public void updateGenre2(int bookId, Genre genre) {
        this.bookRepository.updateBookByGenre(bookId, genre);
    }
}
