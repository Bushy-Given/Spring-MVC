package com.mvc.loginapp.services.imp;

import com.mvc.loginapp.entities.User;
import com.mvc.loginapp.repositories.UserRepository;
import com.mvc.loginapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //GET operations
    @Override
    @Transactional(readOnly = true)
    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }
    @Override
    @Transactional(readOnly = true)
    public  Optional<User> getByid(Long id){
       return userRepository.findById(id);
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }
    //SAVE Operations
    @Override
    public Iterable<User> saveAllusers(Iterable<User> users){
        return userRepository.saveAll(users);
    }
    @Override
    public User saveOneUser(User user){
        return userRepository.save(user);
    }

    //DELETE operations
    @Override
    public  void deleteById(Long id){
        userRepository.deleteById(id);
    }
    @Override
    public void deleteAllUser(){
        userRepository.deleteAll();
    }
    @Override
    public boolean existsByUsername(String username){
        return userRepository.existsByUsername(username);
    }
    @Override
    public long countUsers(){
        return userRepository.count();
    }

}
