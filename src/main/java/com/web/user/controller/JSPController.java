package com.web.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
public class JSPController {

    @Autowired
    private LoginController loginController;

    @RequestMapping(value ="/jsp", method = RequestMethod.GET)
    public String test(HttpServletRequest request, HttpServletResponse response, ModelAndView modelAndView){
        ResponseEntity responseEntity = loginController.login(request, response, "zhangsan", "111111");
        responseEntity.getHeaders().get("signal");
        System.out.println(responseEntity.getHeaders().get("signal"));
        return "hello";
    }
}
