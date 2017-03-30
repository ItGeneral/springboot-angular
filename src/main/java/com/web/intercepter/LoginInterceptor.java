package com.web.intercepter;

import com.web.enums.HttpCodeEnum;
import com.web.utils.MD5Util;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2016/10/20.
 * @Author SongJiuHua.
 * @description 登录拦截器
 */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

    /**
     * 拦截器预处理 思路：
     * 通过拦截器， 对系统中的页面和资源进行访问拦截，同时对于登陆本身相关的页面和资源不拦截。
     * 排除登录、注册的url
     *
     * 用户登录后，将userId结合秘钥进行加密生成一个签名 返回给前端
     * 当用户再次访问后，再将userId结合秘钥生成一个签名，将新生成的签名和传过来的签名进行对比，如果一样，则说明登陆了，如果不相同，则表示没有登录
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登录拦截、性能监控，只有返回true时，才会执行下面的postHandle方法
        Cookie[] cookies = request.getCookies();
        Map cookieMap = new HashMap();
        for (Cookie cookie : cookies){
            cookieMap.put(cookie.getName(), cookie.getValue());
        }
        String userId = (String) cookieMap.get("userId");
        String signal = (String) cookieMap.get("signal");
        if (StringUtils.isEmpty(userId) || StringUtils.isEmpty(signal)){
            response.setStatus(HttpCodeEnum.NO_PRIVILEGE.getCode());
            return false;
        }
        String newSignal = MD5Util.getEncryptedString(userId, "SHA-256");
        if (!newSignal.equals(signal)){
            response.setStatus(HttpCodeEnum.NO_PRIVILEGE.getCode());
            return false;
        }
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
