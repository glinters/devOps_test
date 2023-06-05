package com.example.bookrecomendation.controller;

import com.example.bookrecomendation.model.User;
import com.example.bookrecomendation.service.UserServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/register")
    public User register(String username, String password) {
        return userServiceImpl.register(username, password);
    }

    @PostMapping("/update")
    public User update(@RequestBody User user) {
        return userServiceImpl.update(user);
    }

    @GetMapping("/login")
    public User login(String username, String password) {
        return userServiceImpl.login(username, password);
    }

}
