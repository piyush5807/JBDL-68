package com.example.minorproject1.controllers;

import com.example.minorproject1.models.Student;
import com.example.minorproject1.models.TransactionType;
import com.example.minorproject1.models.User;
import com.example.minorproject1.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    /**
     * Way 1
     *   Separate APIs for issuance and return
     *   Issuance: StudentId + bookId
     *   Return: studentId  + bookId
     *
     * Way 2
     *  Single API i.e initiate transaction
     *      StudentId + bookId + type of txn
     */

    @Autowired
    TransactionService transactionService;


    @PostMapping("/initiate")
    public String initiateTxn(@RequestParam("bookId") Integer bookId,
                              @RequestParam("transactionType")TransactionType transactionType) throws Exception {

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

        return this.transactionService.initiateTransaction(studentId, bookId, transactionType);
    }


}
