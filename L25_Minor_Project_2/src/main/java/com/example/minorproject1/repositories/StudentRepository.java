package com.example.minorproject1.repositories;

import com.example.minorproject1.models.Student;
import com.example.minorproject1.models.StudentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Transactional
    @Modifying
    @Query("update Student s set s.status = ?2 where s.id = ?1")
    void deactivate(int studentId, StudentStatus status);
}
