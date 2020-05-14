package com.example.globalexception.controller;

import com.example.globalexception.exception.CustomException;
import com.example.globalexception.exception.CustomExceptionType;
import com.example.globalexception.exception.ModelView;
import com.example.globalexception.model.AjaxResponse;
import com.example.globalexception.model.User;
import com.example.globalexception.service.ExceptionService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController
public class HelloController {
    @GetMapping("/index")
    public AjaxResponse success(){
        return AjaxResponse.success("响应成功");
    }

    @Resource
    ExceptionService exceptionService;

    /**
     * 模拟人为系统异常
     * @return
     */
    @GetMapping("/ex/system")
    public AjaxResponse systemEx(){
        // 调用人为异常方法
        exceptionService.systemBizError();
        return AjaxResponse.success();
    }

    /**
     * 模拟人为系统异常
     * @return
     */
    @GetMapping("/ex/user/{input}")
    public AjaxResponse userEx(@PathVariable Integer input){
        // 调用人为异常方法
        exceptionService.userBizError(input);
        return AjaxResponse.success();
    }

    /**
     * 模拟使用@Valid注解，用户name不能为空
     * @param user
     * @return
     */
    @PostMapping("/ex/user/valid")
    public AjaxResponse userValid(@RequestBody @Valid User user){
        return AjaxResponse.success(user);
    }

 }
