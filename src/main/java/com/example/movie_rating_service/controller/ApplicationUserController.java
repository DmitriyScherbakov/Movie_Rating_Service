package com.example.movie_rating_service.controller;

import com.example.movie_rating_service.exception.UserNotFoundException;
import com.example.movie_rating_service.model.ApplicationUser;
import com.example.movie_rating_service.service.ApplicationUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user")
public class ApplicationUserController {

    @Autowired
    private ApplicationUserService applicationUserService;

    @GetMapping("/getAll")
    public List<ApplicationUser> getAllUsers(){
        return applicationUserService.getAllUsers();
    }


    @GetMapping("/findById/{id}")
    public ApplicationUser getUserById(@PathVariable long id){
        ApplicationUser userObj = applicationUserService.getUserById(id);
        if (userObj  == null){
            throw new UserNotFoundException("User with id: " + id + " is not found" );
        }else {
            return userObj;
        }
    }

}
