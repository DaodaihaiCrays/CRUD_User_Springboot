package com.daihai.crud_first.service;

import com.daihai.crud_first.model.User;
import com.daihai.crud_first.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User req) {
        if(userRepository.existsByUsername(req.getUsername()))
            throw new RuntimeException("User existed");

        return userRepository.save(req);
    }

    public List<User> getUsers() {
        return  userRepository.findAll();
    }

    public  User getUserById(String id) {
        return  userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUser(User userUpdate) {
        return userRepository.save(userUpdate);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
