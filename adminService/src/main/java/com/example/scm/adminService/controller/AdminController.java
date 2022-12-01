package com.example.scm.adminService.controller;


import com.example.scm.adminService.entity.Admin;
import com.example.scm.adminService.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {


    @Autowired
    AdminRepository adminRepository;

    @PostMapping("/create")
    public ResponseEntity<Admin> createUser(@RequestBody Admin admin) {
        try {
            Admin _admin=adminRepository.save(new Admin(admin.getEmail(),admin.getPassword()));
            return new ResponseEntity<>(_admin, HttpStatus.CREATED);
        }catch(Exception e) {
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}



