package com.example.springfinal.service;

import com.example.springfinal.entity.User;
import com.example.springfinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository ur;

    public User getUser(String number) {
        return ur.find(number);
    }
}
