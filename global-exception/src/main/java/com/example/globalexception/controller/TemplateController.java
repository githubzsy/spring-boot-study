package com.example.globalexception.controller;

import com.example.globalexception.exception.ModelView;
import com.example.globalexception.service.ExceptionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/template")
public class TemplateController {

    @Resource
    ExceptionService exceptionService;

    @ModelView
    @GetMapping("/modelViewException")
    public String modelViewException(Model model){
        exceptionService.systemBizError();
        return "success";
    }
}
