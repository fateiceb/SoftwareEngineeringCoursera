package com.nwnu.fundamentaloperations.controller;

import com.nwnu.fundamentaloperations.domain.UserEntity;
import com.nwnu.fundamentaloperations.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRestController {
    @Autowired
    private UserRepository userRepository;
    @RequestMapping(value = "/user")
    public List<UserEntity> getUsers(){
        return userRepository.findAll();
    }
}
