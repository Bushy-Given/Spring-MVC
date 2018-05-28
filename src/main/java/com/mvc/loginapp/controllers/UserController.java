package com.mvc.loginapp.controllers;

import com.mvc.loginapp.entities.User;
import com.mvc.loginapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="mvc/")
public class UserController {

    private UserService userService;
    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }


    @GetMapping("users")
    public  Iterable<User> users(){
        return  userService.getAllUsers();
    }
    @GetMapping("user/{id}")
    public Optional<User> userById(@PathVariable Long id){
        return  userService.getByid(id);
    }

    @PostMapping("users")
    public Iterable<User> users(@RequestBody Iterable<User> users){
        return  userService.saveAllusers(users);
    }

    @PostMapping("user")
    public  User oneUser(@RequestBody User user){
        return  userService.saveOneUser(user);
    }
}
