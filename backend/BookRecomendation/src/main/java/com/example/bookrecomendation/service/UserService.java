package com.example.bookrecomendation.service;

import com.example.bookrecomendation.model.User;

public interface UserService {

    User register(String username, String password);

    User update(User user);

}
