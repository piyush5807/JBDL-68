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
public class Student {

    /**
     * Rahul - rahul@gmail.com --> abhishek@gmail.com
     * Abhishek - abhishek@gmail.com
     * Sagar - sagar@gmail.com
     *
     * select * from student where email = 'abhishek@gmail.com';
     * if(student.length > 0){ throw BadRequest ....}
     *
     * unique constraint violation exception... => 400
     * apply constraints and handle them properly,
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(unique = true)
    private String email;

    @Column(unique = true, nullable = false)
    private String mobile;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    @OneToMany(mappedBy = "student")
    @JsonIgnoreProperties("student")
    private List<Book> bookList;

    @OneToMany(mappedBy = "student")
    @JsonIgnoreProperties("student")
    private List<Transaction> transactions;

    @Enumerated(value = EnumType.STRING)
    private StudentStatus status;

}
