package com.example.demojpa.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "my_book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // auto increment annotation
    private int id;

    @Column(name = "book_name", nullable = false, length = 50)
    private String name;

//    Integer => null , int => 0

    @Column(nullable = false)
    private String author;

    @Enumerated()
    private Genre genre;

    private String authorCountry;

    @Column(unique = true)
    private String authorEmail;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;
}
