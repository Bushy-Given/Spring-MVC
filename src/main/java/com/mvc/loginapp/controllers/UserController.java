package com.mvc.loginapp.controllers;

import com.mvc.loginapp.entities.User;
import com.mvc.loginapp.services.imp.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {
    public static  final String BASE_URL="login-app/v1/";
    private UserServiceImpl userService;
    @Autowired
    public UserController(UserServiceImpl userService){
        this.userService = userService;
    }


    @GetMapping("users")
    public  Iterable<User> users(){
        return  userService.getAllUsers();
    }
    @GetMapping("user/{id}")
    public Optional<User> userById(@PathVariable("id") Long id){
        return  userService.getByid(id);
    }
    @GetMapping("username/{username}")
    public Optional<User> userByUsername(@PathVariable String username){
        return userService.findByUsername(username);
    }
    @PostMapping("users")
    public Iterable<User> users(@RequestBody Iterable<User> users){
        return  userService.saveAllusers(users);
    }
    @PostMapping("user")
    public  User oneUser(@RequestBody User user){
        return  userService.saveOneUser(user);
    }

    @DeleteMapping("user/{id}")
    public Iterable<User> removeUser(@PathVariable Long id){
        userService.deleteById(id);
        return userService.getAllUsers();
    }
    @DeleteMapping("users")
    public Iterable<User> removeAllUsers(){
        userService.deleteAllUser();
        return userService.getAllUsers();
    }
    @GetMapping("found/{username}")
    public boolean findIfExist(@PathVariable String username){
        return userService.existsByUsername(username);
    }
    @GetMapping("users/count")
    public long countUsers(){
        return  userService.countUsers();
    }
}
