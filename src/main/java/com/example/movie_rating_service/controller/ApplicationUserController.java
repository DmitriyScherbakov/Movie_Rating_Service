package com.example.movie_rating_service.controller;

import com.example.movie_rating_service.exception.UserNotFoundException;
import com.example.movie_rating_service.model.ApplicationUser;
import com.example.movie_rating_service.service.ApplicationUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@Slf4j
@RequestMapping("/user")
public class ApplicationUserController {

    private final ApplicationUserService applicationUserService;

    @Autowired
    public ApplicationUserController(ApplicationUserService applicationUserService) {
        this.applicationUserService = applicationUserService;
    }

    @GetMapping("/getAll")
    public List<ApplicationUser> getAllUsers(){
        return applicationUserService.getAllUsers();
    }

    @PostMapping("/create")
    public ApplicationUser createUser(@RequestBody ApplicationUser userObj){
        applicationUserService.createUser(userObj);
        return userObj;
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

    @DeleteMapping("/deleteById/{id}")
    public String deleteUserById(@PathVariable long id){
        applicationUserService.deleteUserById(id);
        return "User has been deleted with id:" + id;
    }

    @PutMapping("/update/{id}")
    public ApplicationUser updateUser(@PathVariable Long id, @RequestBody ApplicationUser userObj){
        // Поиск пользователя по id
        ApplicationUser existingUser = applicationUserService.getUserById(id);

        if (existingUser == null) {
            // Если пользователь с указанным id не найден, верните какую-то ошибку или бросьте исключение
            // Например, можно использовать ResponseEntity с кодом статуса 404 (Not Found)
            throw new RuntimeException("User with id: " + id + " is not found" );
        }

        // Обновите данные существующего пользователя с данными из userObj
        existingUser.setLogin(userObj.getLogin());
        existingUser.setPassword(userObj.getPassword());
        existingUser.setRole(userObj.getRole());
        // Другие поля, которые нужно обновить

        // Сохраните обновленного пользователя в базе данных
        applicationUserService.updateUser(id, existingUser);

        // Верните обновленного пользователя
        return existingUser;
    }

}
