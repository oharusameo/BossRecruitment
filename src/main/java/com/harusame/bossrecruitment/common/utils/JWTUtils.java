package com.harusame.bossrecruitment.common.utils;


import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.harusame.bossrecruitment.exception.BusinessException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtils {

    @Value("${jwt.expire}")
    private Integer expire;

    @Value("${jwt.secret}")
    private String secret;


    public String generateToken(String userId) {
        Algorithm algorithm = Algorithm.HMAC512(secret);
        JWTCreator.Builder builder = JWT.create();
        DateTime date = DateUtil.offset(new Date(), DateField.DAY_OF_YEAR, expire);
        return builder.withClaim("userId", userId)
                .withExpiresAt(date)
                .sign(algorithm);
    }

    public String generateToken(String userId, String bossId) {
        Algorithm algorithm = Algorithm.HMAC512(secret);
        JWTCreator.Builder builder = JWT.create();
        DateTime date = DateUtil.offset(new Date(), DateField.DAY_OF_YEAR, expire);
        return builder.withClaim("userId", userId)
                .withClaim("bossId", bossId)
                .withExpiresAt(date)
                .sign(algorithm);
    }

    /**
     * 验证令牌合法性，如果不合法(假令牌或过期)会抛出异常
     *
     * @param token
     */
    public void verifyToken(String token) {
        if (StringUtils.isBlank(token)) {
            throw new BusinessException("token为空");
        }
        JWTVerifier verifier = JWT.require(Algorithm.HMAC512(secret)).build();
        verifier.verify(token);
    }

    public String getUserIdFromToken(String token) {
        DecodedJWT decode = JWT.decode(token);
        return decode.getClaim("userId").asString();
    }

    public String getBossIdFromToken(String token) {
        DecodedJWT decode = JWT.decode(token);
        return decode.getClaim("bossId").asString();
    }

}
