package com.cola.ommap.service.impl;

import com.cola.ommap.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

import static com.cola.ommap.constant.RedisConstant.Email_Pre;


@Slf4j
@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendValidateCode(String email) {
        // Search if there is validate code cache in redis
        String code = redisTemplate.opsForValue().get(Email_Pre + email);
        if(StringUtils.hasText(code)){
            return;
        }

        // if not, generate validate code
        String validateCode = RandomStringUtils.randomNumeric(6);
        log.info(validateCode);

        // put validate code into redis with 5 mins time limit
        redisTemplate.opsForValue().set(Email_Pre + email.toLowerCase(), validateCode, 5, TimeUnit.MINUTES);

        // send validate code
        sendAuthCodeEmail(email, validateCode);
    }

    private void sendAuthCodeEmail(String email, String validateCode) {
        // 创建一个简单的邮件对象
        SimpleMailMessage message = new SimpleMailMessage();

        // 发件人和收件人等信息
        message.setFrom("omlink@foxmail.com");
        message.setTo(email);                         // 收件人
        message.setSubject("Verification Code");               // 主题
        message.setText("Your verification code is: " + validateCode);                     // 内容

        // 发送邮件
        mailSender.send(message);
    }

}
