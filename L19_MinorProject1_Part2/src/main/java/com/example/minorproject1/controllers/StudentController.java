package com.example.minorproject1.controllers;

import com.example.minorproject1.dtos.CreateStudentRequest;
import com.example.minorproject1.dtos.GetStudentDetailsResponse;
import com.example.minorproject1.dtos.UpdateStudentRequest;
import com.example.minorproject1.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping()
    public Integer createStudent(@Valid @RequestBody CreateStudentRequest request){
        return studentService.create(request);
    }

    @GetMapping("/{studentId}")
    public GetStudentDetailsResponse getStudentDetails(
            @PathVariable("studentId") int studentId,
            @RequestParam(value = "require-book-list", required = false, defaultValue = "false") boolean requireBookList){
        return this.studentService.getStudentDetails(studentId, requireBookList);
    }

    @PatchMapping("/{studentId}")
    public GetStudentDetailsResponse updateStudentDetails(
            @PathVariable("studentId") Integer studentId,
            @Valid @RequestBody UpdateStudentRequest request){

        return this.studentService.update(studentId, request);
    }

    @DeleteMapping("/{studentId}")
    public GetStudentDetailsResponse deactivateStudent(
            @PathVariable("studentId") int studentId
    ){
        return studentService.deactivate(studentId);
    }
}
