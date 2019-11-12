package com.test.websockettest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by wangli
 * 2019/11/12  17:03
 */
@Configuration
public class AxiosConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加自定义过滤器，添加拦截路径
        MyAxiosInterceptor myAxiosInterceptor = new MyAxiosInterceptor();
        registry.addInterceptor(myAxiosInterceptor).addPathPatterns("/**");
    }
}
