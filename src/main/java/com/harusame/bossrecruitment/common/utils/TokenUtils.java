package com.harusame.bossrecruitment.common.utils;

import com.harusame.bossrecruitment.common.utils.JWTUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Component
public class TokenUtils {
    @Resource
    private JWTUtils jwtUtils;

    public String getUserIdFromHeader() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
        String token = request.getHeader("token");
        return jwtUtils.getUserIdFromToken(token);
    }

    public String getBossIdFromHeader() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
        String token = request.getHeader("token");
        return jwtUtils.getBossIdFromToken(token);
    }
}
