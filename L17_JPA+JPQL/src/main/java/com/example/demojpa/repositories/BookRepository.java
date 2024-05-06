package com.example.demojpa.repositories;

import com.example.demojpa.models.Book;
import com.example.demojpa.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

//    @Override
//    List<Book> findAll();
    /**
     * 1. JPQL - Java persistence query language
     * format where we write queries keeping java objects in mind
     *
     * 2. Native query -
     * format where we write queries keeping sql tables in mind
     */

//    @Query(value = "select b from my_book b where b.genre = ?1", nativeQuery = true) // abstraction given by jpa to the end user to write their own custom queries
////    @Query("select * from my_book where genre = :g")
//
//    @Query("select b from Book b where b.genre = ?1")
//    List<Book> findByGenre(Genre g);
//
    @Query("select b from Book b where b.authorEmail = :name") // JPQL
    List<Book> findByAuthorJPQL(String name);

    @Query(value = "select * from book b where b.author_email = :name", nativeQuery = true) // native query
    List<Book> findByAuthorNative(String name);


    List<Book> findByGenre(Genre genre); // => @Query("select b from Book b where b.genre = ?1")
                                         //    List<Book> findByGenre(Genre genre)

    List<Book> findByGenreOrAuthorEmail(Genre genre, String authorEmail);

    List<Book> findByAuthorEmailLike(String pattern);

    @Transactional()
    @Modifying()
    @Query("update Book b set b.genre = ?2 where b.id = ?1")
    void updateBookByGenre(int bookId, Genre genre);

    /**
     * DDL - drop, alter, create table, create index.
     * DML - update, insert, delete
     * DQL - Data query language (select)
     */


    List<Book> findByGenreAndAuthorCountry(Genre genre, String authorEmail);
//    List<Book> findByCreatedOnGreaterThanAndCreatedOnLessThan(Date from, Date to);

}
