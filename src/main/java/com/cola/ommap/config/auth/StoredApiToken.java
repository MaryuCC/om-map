package com.cola.ommap.config.auth;

import com.alibaba.fastjson.JSON;

import com.cola.ommap.repository.entity.user.User;
import com.cola.ommap.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collections;

import static com.cola.ommap.constant.RedisConstant.Login_Token_Pre;


@Service
public class StoredApiToken {
    @Autowired
    RedisTemplate<String, String> redisTemplate;
    @Autowired
    UserInfoService userInfoService;

    public UsernamePasswordAuthenticationToken verifyToken(String token) {
        try {
            String userJson = redisTemplate.opsForValue().get(Login_Token_Pre + token);
            User user = JSON.parseObject(userJson, User.class);
            String email = user.getEmail();

            String userRole = userInfoService.getUserRoleByUserId(user.getId()).name();

            return new UsernamePasswordAuthenticationToken(
                email,
                null,
                Collections.singletonList(new SimpleGrantedAuthority(userRole))
            );
        } catch (Exception e) {
            return null;
        }
    }
}
