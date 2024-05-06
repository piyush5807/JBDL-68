package com.example.minorproject1.repositories;

import com.example.minorproject1.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
