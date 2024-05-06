package com.example.demojpa.controllers;

import com.example.demojpa.models.Student;
import com.example.demojpa.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @PostMapping("/student")
    public Student create(@RequestParam("name") String name){
        return studentRepository.save(
                Student.builder()
                        .name(name)
                        .build()
        );
    }

}
