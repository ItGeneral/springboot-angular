package com.web.business;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @Date Created on 2017/4/21.
 * @Author SongJiuHua.
 * @description
 */
@Controller
public class AppController {

    @RequestMapping(value ={"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model, HttpServletRequest request){
        return "index";
    }

}
