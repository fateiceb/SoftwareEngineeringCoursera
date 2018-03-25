package com.nwnu.fundamentaloperations.controller;

import com.nwnu.fundamentaloperations.domain.UserEntity;
import com.nwnu.fundamentaloperations.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/Login")
    public String login(){
        return "/views/login";
    }


    @RequestMapping(value = "/index")
    public String home(){
        return "/views/index";
    }

    @RequestMapping(value = "/admin/index")
    public String adminIndex(){
        return "/views/_exam/index";
    }

}
