package com.example.minorproject1.controllers;

import com.example.minorproject1.dtos.CreateStudentRequest;
import com.example.minorproject1.dtos.GetStudentDetailsResponse;
import com.example.minorproject1.dtos.UpdateStudentRequest;
import com.example.minorproject1.models.Authority;
import com.example.minorproject1.models.Student;
import com.example.minorproject1.models.User;
import com.example.minorproject1.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping() // similar to /user/signup
    public Integer createStudent(@Valid @RequestBody CreateStudentRequest request){
        return studentService.create(request);
    }

    /**
     * Admin can see any student's details
     * A particular student can see his/her details
     * @param studentId
     * @param requireBookList
     * @return
     */

    @GetMapping("/admin/{studentId}") // authority of admin
    public GetStudentDetailsResponse getStudentDetailsForAdmin(
            @PathVariable("studentId") Integer studentId,
            @RequestParam(value = "require-book-list", required = false, defaultValue = "false") boolean requireBookList
    ) throws Exception {

        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        User user = (User) authentication.getPrincipal();

//        if(!user.getAuthorities().contains(Authority.ADMIN)){
//            throw new Exception("user is not an admin");
//        }

//        if(user.getAdmin() == null || user.getStudent() != null){
//            throw new Exception("user is not an admin");
//        }

        return this.studentService.getStudentDetails(studentId, requireBookList);

    }

    @GetMapping("") // authority of student
    public GetStudentDetailsResponse getStudentDetails(
            @RequestParam(value = "require-book-list", required = false, defaultValue = "false") boolean requireBookList) throws Exception {

        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        User user = (User) authentication.getPrincipal();
        Student student = user.getStudent();

//        if(!user.getAuthorities().contains(Authority.STUDENT)){
//            throw new Exception("user is not a student");
//        }

        Integer studentId = null;
        if(student != null){
            studentId = student.getId();
        }else{
            throw new Exception("User is not student");
        }


        return this.studentService.getStudentDetails(studentId, requireBookList);
    }

    /**
     * SecurityContextHolder
     *   |    |    |    \
     *   s1   s2   s3   s4
     *   {t1}  {t2}  {t3}  {t4}
     *
     *   t1 - 10 AM
     *   t2 - 10:30 AM
     *   t3 - 10:45 AM
     *   t4 - 11:05 AM
     * @param studentId
     * @param request
     * @return
     */

    @PatchMapping("")
    public GetStudentDetailsResponse updateStudentDetails(
            @Valid @RequestBody UpdateStudentRequest request) throws Exception {

        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        User user = (User) authentication.getPrincipal();
        Student student = user.getStudent();

        Integer studentId = null;
        if(student != null){
            studentId = student.getId();
        }else{
            throw new Exception("User is not student");
        }

        return this.studentService.update(studentId, request);
    }

    @DeleteMapping("")
    public GetStudentDetailsResponse deactivateStudent() throws Exception {

        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication authentication = securityContext.getAuthentication();
        User user = (User) authentication.getPrincipal();
        Student student = user.getStudent();

        Integer studentId = null;
        if(student != null){
            studentId = student.getId();
        }else{
            throw new Exception("User is not student");
        }

        return studentService.deactivate(studentId);
    }
}
