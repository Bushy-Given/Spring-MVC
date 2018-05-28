package com.mvc.loginapp.services;

import com.mvc.loginapp.entities.User;
import com.mvc.loginapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //GET operations
    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getByid(Long id){
       return userRepository.findById(id);
    }

    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }
    //SAVE Operations
    public Iterable<User> saveAllusers(Iterable<User> users){
        return userRepository.saveAll(users);
    }

    public User saveOneUser(User user){
        return userRepository.save(user);
    }

    //DELETE operations
    public  void deleteById(Long id){
        userRepository.deleteById(id);
    }

    public void deleteAllUser(){
        userRepository.deleteAll();
    }

}
