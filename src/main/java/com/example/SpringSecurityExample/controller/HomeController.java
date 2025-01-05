package com.example.SpringSecurityExample.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @RequestMapping("/")
    public String home(HttpServletRequest request){
        return "Welcome Our Page" + request.getSession().getId();
    }
}
