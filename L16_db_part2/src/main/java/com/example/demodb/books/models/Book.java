package com.example.demodb.books.models;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Book {

    // IDE - IntelliJ , Eclipse, Netbeans

    // Dependency - Lombok - {code to generate boiler plate code}

    private int id; // auto incremented field

    private String name;

//    Integer => null , int => 0

    private String authorName;

    private Genre genre;

    private String authorCountry;

    private String authorEmail;

    private Date createdOn;

    private Date updatedOn;

//    public Book setId(int id) {
//        this.id = id;
//        return this;
//    }
//
//    public Book setName(String name) {
//        this.name = name;
//        return this;
//    }
//
//    public Book setAuthorName(String authorName) {
//        this.authorName = authorName;
//        return this;
//    }
//
//    public Book setGenre(Genre genre) {
//        this.genre = genre;
//        return this;
//    }
//
//    public Book setAuthorCountry(String authorCountry) {
//        this.authorCountry = authorCountry;
//        return this;
//    }
//
//    public Book setAuthorEmail(String authorEmail) {
//        this.authorEmail = authorEmail;
//        return this;
//    }
//
//    public Book setCreatedOn(Date createdOn) {
//        this.createdOn = createdOn;
//        return this;
//    }
//
//    public Book setUpdatedOn(Date updatedOn) {
//        this.updatedOn = updatedOn;
//        return this;
//    }
//
//    public Book updatedOn(Date updatedOn){
//        this.updatedOn = updatedOn;
//        return this;
//    }
//
//    /**
//     * a1, a2, a3
//     *
//     * Book(a1, a2, a3)
//     * Book(a1, a3, a2)
//     * ..
//     * ..
//     */
//
//    public Book setExternalId(String externalId) {
//        System.out.println("Inside externalId setter....");
//        this.externalId = externalId;
//        return this;
//    }
}
