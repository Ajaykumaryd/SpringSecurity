package com.SpringSecurity.SpringSecurityTurtorial.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {


    @GetMapping("/get")
    public String getAdmin(){
        return "Welcome Admin";
    }










}
