package com.web.user.controller;

import com.web.user.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author keven-song.
 * Created on 2017/2/13.
 * @Description
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping("")
    @ResponseBody
    public ResponseEntity test(){
        User user = new User();
        user.setUserName("john");
        user.setRealName("张三");
        user.setPassword("111111");
        user.setEmail("799178171@qq.com");
        user.setTelephone("18801915767");
        System.out.println("-----------1-----");
        List<User> users = new ArrayList<>();
        users.add(user);
        return ResponseEntity.ok().body(users);
    }




}
