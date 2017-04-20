package com.web.user.controller;

import com.web.base.BaseController;
import com.web.user.model.User;
import com.web.user.service.UserService;
import com.web.utils.MD5Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author keven-song.
 * Created on 2017/1/21.
 * @Description
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController extends BaseController{

    private final static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;
    /**
     * 登陆后 用userId和privateKey（秘钥）生成一个签名，并将userId和签名一同返回给前端
     * @param request
     * @param response
     */
    @RequestMapping(value = "")
    @ResponseBody
    public ResponseEntity login(HttpServletRequest request, HttpServletResponse response, @RequestParam String userName, @RequestParam String password){
        try{
            User user = userService.queryUserByUserName(userName);
            if (user == null){
                return badRequest(HttpStatus.BAD_REQUEST).put("message", "用户名不存在").build();
            }
            String mdPassword = MD5Util.getEncryptedString(password);
            if (!user.getPassword().equals(mdPassword)){
                return badRequest(HttpStatus.BAD_REQUEST).put("message", "密码不正确").build();
            }
            //将userId和signal（签名）返回前端cookie中
            request.setAttribute("userId", user.getId().toString());
            request.setAttribute("signal", MD5Util.getEncryptedString(user.getId().toString(), "SHA-256"));
            response.setHeader("userId", user.getId().toString());
            response.setHeader("signal", MD5Util.getEncryptedString(user.getId().toString(), "SHA-256"));
            return ok().put("message", "登录成功").build();
        }catch (Exception e){
            logger.error("登录异常", e);
            return badRequest(HttpStatus.INTERNAL_SERVER_ERROR).put("message", "登录异常，请稍后重试").build();
        }
    }

    @RequestMapping(value = "register")
    public ResponseEntity register(@RequestBody User user){
        userService.insertUser(user);
        return ok().put("message", "注册成功").build();
    }

}
