package com.web.intercepter;

import com.web.user.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created on 2016/10/20.
 * @Author SongJiuHua.
 * @description 登录拦截器
 */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

    private static final String userSession = "login_user";

    /**
     * 拦截器预处理 思路：先登陆后，将登陆信息存储在session中，然后通过拦截器，
     * 对系统中的页面和资源进行访问拦截，同时对于登陆本身相关的页面和资源不拦截。
     * 排除登录、注册的url
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录拦截、性能监控，只有返回true时，才会执行下面的postHandle方法
        User user = (User) request.getSession().getAttribute(userSession);
        System.out.println("--------preHandle--------");
        return true;
    }


    /**
     * 拦截器后处理器
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("--------postHandle--------");
    }

    /**
     * 拦截器处理完后的回调
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("--------afterCompletion--------");
    }

}
