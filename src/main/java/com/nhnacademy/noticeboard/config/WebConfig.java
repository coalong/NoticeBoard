package com.nhnacademy.noticeboard.config;


import com.nhnacademy.noticeboard.intercepter.LoginCheckIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginCheckIntercepter())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/login", "/");
    }
}

