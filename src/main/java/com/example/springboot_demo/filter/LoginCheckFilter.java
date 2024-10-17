package com.example.springboot_demo.filter;

import com.alibaba.fastjson2.JSONObject;
import com.example.springboot_demo.pojo.Result;
import com.example.springboot_demo.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Slf4j
//@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 将ServletRequest和ServletResponse转换为HttpServletRequest和HttpServletResponse
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        // 获取请求的URL
        String url = req.getRequestURL().toString();
        // 记录拦截到的URL
        log.info("拦截请求的url：{}", url);

        // 如果URL包含"login"，则认为是登录请求，直接放行
        if (url.contains("login")) {
            log.info("登录请求，放行");
            chain.doFilter(request, response);
            return;
        }

        // 从请求头中获取名为"token"的JWT令牌
        String jwt = req.getHeader("token");

        // 如果JWT令牌为空，返回未登录信息
        if(!StringUtils.hasLength(jwt)){
            log.info("请求头token为空，返回未登录信息");
            Result error = Result.error("NOT_LOGIN");
            String notlogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notlogin);
            return;
        }

        // 尝试解析JWT令牌，如果解析失败，返回未登录信息
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            log.info("解析令牌失败，返回未登录信息");
            Result error = Result.error("NOT_LOGIN");
            String notlogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notlogin);
            return;
        }

        // 如果JWT令牌验证通过，放行请求
        log.info("已验证通过，放行");
        chain.doFilter(request, response);
    }
}
