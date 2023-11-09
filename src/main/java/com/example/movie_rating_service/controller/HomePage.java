package com.example.movie_rating_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePage {

    @GetMapping("/homepage")
    public String homePage(){
        return "homepage";
    }
}
