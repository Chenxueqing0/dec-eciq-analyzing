package com.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: ps
 * @Description:
 * @Date: Created in 2019/11/4 18:51
 */
@Configuration
public class LoginConfiguration implements WebMvcConfigurer {

    @Bean
    public HandlerInterceptor getLoginInterceptor() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 注册拦截器
        InterceptorRegistration loginRegistry = registry.addInterceptor(getLoginInterceptor());
        // 拦截路径
        loginRegistry.addPathPatterns("/**");
        // 排除路径
        loginRegistry.excludePathPatterns("/");
        loginRegistry.excludePathPatterns("/login.html");
        loginRegistry.excludePathPatterns("/loginController/*");

        // 排除资源请求
        loginRegistry.excludePathPatterns("/css/*.css");
        loginRegistry.excludePathPatterns("/img/*.*");
        loginRegistry.excludePathPatterns("/js/*.js");
        loginRegistry.excludePathPatterns("/js/vue/*.js");
        loginRegistry.excludePathPatterns("/js/jquery/*.js");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/*").addResourceLocations("classpath:/static/");
    }

}
