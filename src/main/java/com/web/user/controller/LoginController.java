package com.web.user.controller;

import com.web.intercepter.LoginInterceptor;
import com.web.user.model.User;
import com.web.user.service.UserService;
import com.web.utils.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author keven-song.
 * Created on 2017/1/21.
 * @Description
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;
    /**
     * 登录
     * 1、
     * @param request
     * @param response
     */
    @RequestMapping(value = "")
    public String login(HttpServletRequest request, HttpServletResponse response, @RequestParam String userName, @RequestParam String password){
        try{
            User user = userService.queryUserByUserName(userName);
            //用户名不存在
            if (user == null){

            }
            String mdPassword = MD5Util.getMD5String(password);
            //密码不正确
            if (!user.getPassword().equals(mdPassword)){

            }
            request.getSession().setAttribute("login_user", user);

            //将登陆信息返回

        }catch (Exception e){
            logger.error("登录异常", e);
        }
        //登录成功跳转至首页
        return "index";
    }

    @RequestMapping(value = "register")
    public void register(@RequestBody User user){

    }

}
