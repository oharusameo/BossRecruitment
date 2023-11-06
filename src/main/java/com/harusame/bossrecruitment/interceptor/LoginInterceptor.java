package com.harusame.bossrecruitment.interceptor;


import com.harusame.bossrecruitment.common.annotation.RequireLogin;
import com.harusame.bossrecruitment.common.utils.JWTUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Resource
    private JWTUtils jwtUtils;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Class<?> clazz = handlerMethod.getBeanType();
            Method method = handlerMethod.getMethod();
            //如果方法或类上贴上了@RequireLogin，则需要做token校验
            if (method.isAnnotationPresent(RequireLogin.class) || clazz.isAnnotationPresent(RequireLogin.class)) {
                String token = request.getHeader("token");
                jwtUtils.verifyToken(token);
            }
            return true;
        }
        return true;
    }
//        AuthContextHolder.setUserId(Integer.valueOf(jwtUtils.getUserIdFromToken(token)));

}
