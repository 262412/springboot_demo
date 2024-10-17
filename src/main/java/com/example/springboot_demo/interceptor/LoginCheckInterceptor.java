package com.example.springboot_demo.interceptor;

import com.alibaba.fastjson2.JSONObject;
import com.example.springboot_demo.pojo.Result;
import com.example.springboot_demo.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
// 登录检查拦截器类，实现HandlerInterceptor接口，用于拦截请求并进行登录检查
public class LoginCheckInterceptor implements HandlerInterceptor {

    /**
     * 在请求处理之前执行的拦截器方法
     * 该方法用于在控制器方法执行之前进行预处理操作，如初始化、身份验证等
     *
     * @param request  请求对象，用于访问请求信息
     * @param response 响应对象，用于向客户端发送响应
     * @param handler  请求处理对象，通常是控制器方法
     * @return boolean 表示是否继续执行下一个拦截器或控制器方法
     * @throws Exception 如果发生异常，则会抛出异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取请求的URL
        String url = request.getRequestURL().toString();
        log.info("拦截请求的url：" + url);
        // 检查URL是否包含"login"，如果是，则直接放行
        if (url.contains("login")) {
            log.info("登录请求，放行");
            return true;
        }
        // 从请求头中获取JWT令牌
        String jwt = request.getHeader("token");
        // 如果JWT为空，则返回未登录信息
        if (!StringUtils.hasLength(jwt)) {
            log.info("请求头token为空，返回未登录信息");
            Result error = Result.error("NOT_LOGIN");
            String notlogin = JSONObject.toJSONString(error);
            response.getWriter().write(notlogin);
            return false;
        }
        // 尝试解析JWT，如果解析失败，则返回未登录信息
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            log.info("解析令牌失败，返回未登录信息");
            Result error = Result.error("NOT_LOGIN");
            String notlogin = JSONObject.toJSONString(error);
            response.getWriter().write(notlogin);
            return false;
        }
        // JWT验证通过，放行
        log.info("令牌合法，放行");
        return true;
    }

    /**
     * 在请求处理之后执行的拦截器方法
     * 该方法用于在控制器方法执行之后，视图渲染之前进行处理操作，如修改模型属性等
     *
     * @param request  请求对象，用于访问请求信息
     * @param response 响应对象，用于向客户端发送响应
     * @param handler  请求处理对象，通常是控制器方法
     * @param modelAndView 模型和视图对象，用于封装模型数据和视图信息
     * @throws Exception 如果发生异常，则会抛出异常
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // 此处可以添加postHandle的注释，但考虑到示例中的方法体未实现具体逻辑，故此处不提供注释
        System.out.println("postHandle");
    }

    /**
     * 在请求处理完成之后执行的拦截器方法
     * 该方法用于在控制器方法和视图渲染都完成之后进行处理操作，如资源清理等
     *
     * @param request  请求对象，用于访问请求信息
     * @param response 响应对象，用于向客户端发送响应
     * @param handler  请求处理对象，通常是控制器方法
     * @param ex  异常对象，如果执行过程中发生异常则为异常对象，否则为null
     * @throws Exception 如果发生异常，则会抛出异常
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 此处可以添加afterCompletion的注释，但考虑到示例中的方法体未实现具体逻辑，故此处不提供注释
        System.out.println("afterCompletion");
    }
}
