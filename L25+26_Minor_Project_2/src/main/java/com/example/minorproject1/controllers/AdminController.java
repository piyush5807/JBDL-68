package com.example.minorproject1.controllers;

import com.example.minorproject1.dtos.CreateAdminRequest;
import com.example.minorproject1.services.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;

    @PostMapping("/admin")
    public Integer createAdmin(@Valid @RequestBody CreateAdminRequest createAdminRequest){
        return adminService.create(createAdminRequest);
    }

}
