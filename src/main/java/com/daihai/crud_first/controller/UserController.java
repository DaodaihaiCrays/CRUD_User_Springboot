package com.daihai.crud_first.controller;

import com.daihai.crud_first.model.ApiRespone;
import com.daihai.crud_first.model.User;
import com.daihai.crud_first.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    ApiRespone<User> createUserController(@RequestBody @Valid User userReq) {

        ApiRespone<User> apiRespone = new ApiRespone<User>();
        apiRespone.setMessage("Success");
        apiRespone.setResult(userService.createUser(userReq));

        return apiRespone;
    }

    @GetMapping
    ApiRespone<User> getUser() {
        ApiRespone<User> apiRespone = new ApiRespone<User>();
        apiRespone.setMessage("Success");
        apiRespone.setResults(userService.getUsers());
        return apiRespone;
    }

    @GetMapping("/{id}")
    ApiRespone<User> getUserById(@PathVariable("id") String id) {
        ApiRespone<User> apiRespone = new ApiRespone<User>();
        apiRespone.setMessage("Success");
        apiRespone.setResult(userService.getUserById(id));
        return apiRespone;
    }

    @PutMapping("/{id}")
    ApiRespone<User> updateUser(@PathVariable("id") String id,@RequestBody User userUpdate) {
        User userById = userService.getUserById(id);

        userById.setUsername(userUpdate.getUsername());
        userById.setPassword(userUpdate.getPassword());
        userById.setFirstName(userUpdate.getFirstName());
        userById.setDob(userUpdate.getDob());

        ApiRespone<User> apiRespone = new ApiRespone<User>();
        apiRespone.setMessage("Success");
        apiRespone.setResult(userService.updateUser(userById));

        return apiRespone;
    }

    @DeleteMapping("/{id}")
    String deleteUser(@PathVariable("id") String id) {
        userService.deleteUser(id);
        return "User has been deleted";
    }
}
