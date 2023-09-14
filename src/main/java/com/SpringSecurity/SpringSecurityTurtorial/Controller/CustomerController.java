package com.SpringSecurity.SpringSecurityTurtorial.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {



    @GetMapping("/get")
    public String getCustomer(){
        return "Welcome Customer";
    }
}
