package com.web.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import com.web.intercepter.LoginInterceptor;

/**
 * Created on 2016/10/20.
 * @Author SongJiuHua.
 * @description 配置拦截器
 */
@Configuration
public class MyInterceptorConfig extends WebMvcConfigurerAdapter {

    /**
     * 配置拦截器，可以配置多个拦截器，配置的拦截器的顺序即是执行的顺序
     * login/**路径访问时不走拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/login/**", "/static/**");
        super.addInterceptors(registry);
    }

    /**
     * 前端静态资源拦截  访问resources下的静态文件
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }

}
