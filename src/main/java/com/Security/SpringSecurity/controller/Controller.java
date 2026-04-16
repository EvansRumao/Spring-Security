package com.Security.SpringSecurity.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("hello")
    public String greed(HttpServletRequest request){
        return "hello"+request.getSession().getId();
    }
}
