package com.noyna.userControl.service;

import com.noyna.userControl.entity.User;
import com.noyna.userControl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public void addUser(User user) {
        userRepository.save(user);
    }

    public List<User> getAllUser(){
        List<User> allUser = userRepository.findAll();
        return allUser;
    }


    public User findById(Long id){
        return userRepository.getById(id);
    }

}
