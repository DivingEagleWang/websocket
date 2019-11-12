package com.test.websockettest.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wangli
 * 2019/11/12  15:44
 */
public class MyAxiosInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String origin = request.getHeader("Origin");
        if(StringUtils.isNotBlank(origin)) {
            response.setHeader("Access-Control-Allow-Origin", origin);
        }

        // 自适应所有自定义头
        String headers = request.getHeader("Access-Control-Request-Headers");
        if(StringUtils.isNotBlank(headers)) {
            response.setHeader("Access-Control-Allow-Headers", headers);
            response.setHeader("Access-Control-Expose-Headers", headers);
        }

        // 允许跨域的请求方法类型
        response.setHeader("Access-Control-Allow-Methods", "*");
        // 预检命令（OPTIONS）缓存时间，单位：秒
        response.setHeader("Access-Control-Max-Age", "3600");
        // 明确许可客户端发送Cookie，不允许删除字段即可
        response.setHeader("Access-Control-Allow-Credentials", "true");
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}
