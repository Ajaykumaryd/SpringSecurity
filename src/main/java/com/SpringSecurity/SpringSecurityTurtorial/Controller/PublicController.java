package com.SpringSecurity.SpringSecurityTurtorial.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class PublicController {




    @GetMapping("/get")
    public String getCustomer(){
        return "Welcome";
    }












}
