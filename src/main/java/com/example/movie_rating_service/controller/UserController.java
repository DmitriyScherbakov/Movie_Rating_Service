package com.example.movie_rating_service.controller;

import com.example.movie_rating_service.exception.UserNotFoundException;
import com.example.movie_rating_service.model.User;
import com.example.movie_rating_service.service.serviceInterfaces.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@Slf4j
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User userObj){
        userService.createUser(userObj);
        return userObj;
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable long id){
        User userObj = userService.getUserById(id);
        if (userObj  == null){
            throw new UserNotFoundException("User with id: " + id + " is not found" );
        }else {
            return userObj;
        }
    }

    @DeleteMapping("/user/{id}")
    public String deleteUserById(@PathVariable long id){
        userService.deleteUserById(id);
        return "User has been deleted with id:" + id;
    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userObj){
        // Поиск пользователя по id
        User existingUser = userService.getUserById(id);

        if (existingUser == null) {
            // Если пользователь с указанным id не найден, верните какую-то ошибку или бросьте исключение
            // Например, можно использовать ResponseEntity с кодом статуса 404 (Not Found)
            throw new RuntimeException("User with id: " + id + " is not found" );
        }

        // Обновите данные существующего пользователя с данными из userObj
        existingUser.setLogin(userObj.getLogin());
        existingUser.setPassword(userObj.getPassword());
        existingUser.setEmail(userObj.getEmail());
        // Другие поля, которые нужно обновить

        // Сохраните обновленного пользователя в базе данных
        userService.updateUser(id, existingUser);

        // Верните обновленного пользователя
        return existingUser;
    }

}
