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
        return "login";
    }

    @RequestMapping(value = "/LoginCheck",method = RequestMethod.POST)
    public String loginCheck(@Param("username") String username, @Param("password") String password,
                             HttpServletRequest request){
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity != null&&userEntity.getPassword().equals(password)){
            request.getSession().setAttribute("user",userEntity);
            return "home";
        }

        return "login";
    }

    @RequestMapping(value = "/home")
    public String home(){
        return "home";
    }
}
