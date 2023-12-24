package com.example.service;

import com.example.domain.User;

public interface UserService {
    User login(String email, String password);
}
