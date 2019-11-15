package com.demo.springboot.controller;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: 刘旭
 * Date: 2019/11/7 19:48
 * @Version 1.0
 */
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(value= UnauthorizedException.class)
    public String defaultErrorHandler(HttpServletRequest request){
        return "unauth";
    }
}
