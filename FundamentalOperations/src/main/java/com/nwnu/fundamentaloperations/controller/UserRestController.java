package com.nwnu.fundamentaloperations.controller;

import com.nwnu.fundamentaloperations.domain.UserEntity;
import com.nwnu.fundamentaloperations.domain.VisualizationEntity;
import com.nwnu.fundamentaloperations.repository.UserRepository;
import com.nwnu.fundamentaloperations.repository.VisualiRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UserRestController {
    private org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VisualiRepository visualiRepository;
    @RequestMapping(value = "/user")
    public List<UserEntity> getUsers(){
        return userRepository.findAll();
    }

    @RequestMapping(value = "/LoginCheck",method = RequestMethod.POST)
    public String loginCheck(@Param("username") String username, @Param("password") String password,
                             HttpServletRequest request){
        UserEntity userEntity = userRepository.findByUsername(username);
        logger.info(username+" "+password);
        if (userEntity != null&&userEntity.getPassword().equals(password)){ ;
        logger.info("sucess");
            request.getSession().setAttribute("user",userEntity);
            return "2";
        }
        logger.info("fail");
        return "1";
    }

    @RequestMapping("/submit")
    @Modifying
    public String submit(@Param(value = "score") String score,HttpServletRequest request){
        HttpSession session  = request.getSession();
        UserEntity userEntity = (UserEntity) session.getAttribute("user");
        VisualizationEntity visualizationEntity = new VisualizationEntity();
        visualizationEntity.setUsername(userEntity.getUsername());
        visualizationEntity.setScore(score);
        visualiRepository.save(visualizationEntity);
        return "success";
    }

    @RequestMapping("/chart")
    public List<VisualizationEntity> getChartData(HttpServletRequest httpServletRequest){
        HttpSession session = httpServletRequest.getSession();
        UserEntity userEntity = (UserEntity) session.getAttribute("user");
        List<VisualizationEntity> visualizationEntities = visualiRepository.findByUsername(userEntity.getUsername());
        return visualizationEntities;
    }
}
