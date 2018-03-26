package com.nwnu.fundamentaloperations.controller;

import com.nwnu.fundamentaloperations.domain.ExpressionEntity;
import com.nwnu.fundamentaloperations.repository.ExpressionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping(value = "/expression")
public class ExpressionController {
    @Autowired
    private ExpressionRepository expressionRepository;
    @RequestMapping(value = "/{type}")
    public String getExpressionPage(@PathVariable(value = "type") String type, Model model){
        List<ExpressionEntity> expressionEntityList = expressionRepository.findByTypeTwenty(type);
        model.addAttribute("expressions",expressionEntityList);
        return "/views/expressionPage";
    }
}
