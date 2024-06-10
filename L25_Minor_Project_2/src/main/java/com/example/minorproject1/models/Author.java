package com.example.minorproject1.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Author {

    // JPA's unidirectional relationships
    // bidirectional relationships

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(unique = true)
    private String email;

    @CreationTimestamp
    private Date createdOn;

    @OneToMany(mappedBy = "author") // attribute name of the forward directional FK attribute
    @JsonIgnoreProperties("author")
    private List<Book> bookList;

}
