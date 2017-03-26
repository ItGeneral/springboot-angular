package com.web.user.controller;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @Author keven-song.
 * Created on 2017/2/13.
 * @Description
 */
@Component
public class TestApplicationListener implements ApplicationListener<ContextRefreshedEvent>{
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //根应用
        if(event.getApplicationContext().getParent() == null){
            //TODO 这里写下将要初始化的内容，比如：加载配置等
        }
    }
}
