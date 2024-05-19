package com.example.minorproject1.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    /**

    // JPA Joins
    // Book : Author (N : 1)
    // authorId as a FK in book table or List<Integer> bookIds as a FK in author table make sense
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    private String name;

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties({"bookList", "createdOn"})
    private Author author;          // cyclic dependency

    @ManyToOne
    @JoinColumn
    @JsonIgnoreProperties({"bookList", "updatedOn"})
    private Student student;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    @OneToMany(mappedBy = "book")
    @JsonIgnoreProperties("book")
    private List<Transaction> transactionList;

    // get book -> {author details as well}
    // get author -> {no book details}

    /**
     * Pros and cons of bidirectional relationships
     * Pro:
     * 1. Hibernate internally will make a call to the book table and fetch the book details
     *    and attach it with the author object
     *
     * Con:
     * 1. Slight delay in getting the data from some other table
     * 2. if you don't handle the dependent attributes properly in the return response, it can lead to stack overflow, infinite loop issue
     *
     *
     * findById() : select * from author where id = 1 (t1)
     *              select * from author a, book b where a.id = 1 and a.id = b.author_id (t2)
     *
     *              t1 < t2
     *              t2 < t1
     *              t1 ~ t2
     *
     */

}
