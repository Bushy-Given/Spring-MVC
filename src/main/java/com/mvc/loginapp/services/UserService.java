package com.mvc.loginapp.services;

import com.mvc.loginapp.entities.User;

import java.util.Optional;

public interface UserService {
    Iterable<User> getAllUsers();
    Optional<User> getByid(Long id);
    Optional<User> findByUsername(String username);
    Iterable<User> saveAllusers(Iterable<User> users);
    User saveOneUser(User user);
    void deleteById(Long id);
    void deleteAllUser();
    boolean existsByUsername(String username);
    long countUsers();
}
