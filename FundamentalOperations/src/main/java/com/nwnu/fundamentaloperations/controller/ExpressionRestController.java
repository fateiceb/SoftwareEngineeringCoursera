package com.nwnu.fundamentaloperations.controller;

import com.nwnu.fundamentaloperations.domain.ExpressionEntity;
import com.nwnu.fundamentaloperations.repository.ExpressionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExpressionRestController {
    @Autowired
    private ExpressionRepository expressionRepository;

    @RequestMapping(value = "/getExpression",method = RequestMethod.POST)
    public List<ExpressionEntity> getExpression(String type){
        return expressionRepository.findByTypeTwenty(type);
    } 
}
