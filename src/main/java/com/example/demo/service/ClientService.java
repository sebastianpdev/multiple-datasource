package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface ClientService {
    List<User> list() throws InterruptedException;
    User findByUsername(String username);
}
