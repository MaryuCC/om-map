package com.cola.ommap.controller;


import com.cola.ommap.repository.dto.h5.UserLoginDto;
import com.cola.ommap.repository.dto.h5.UserRegisterDto;
import com.cola.ommap.repository.vo.common.Result;
import com.cola.ommap.repository.vo.common.ResultCodeEnum;
import com.cola.ommap.service.EmailService;
import com.cola.ommap.service.UserInfoService;
import com.cola.ommap.utils.AuthContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/account")
public class LoginController {

    @Autowired
    EmailService emailService;

    @Autowired
    UserInfoService userInfoService;


    // Register

    //1.1 send verify code
    @GetMapping("sendCode/{email}")
    public Result sendValidateCode(@PathVariable String email){
        emailService.sendValidateCode(email);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }


    // user register
    @PostMapping("register")
    public Result register(@RequestBody UserRegisterDto userRegisterDto){
        userInfoService.register(userRegisterDto);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }


    // Login
    @PostMapping("login")
    public Result login(@RequestBody UserLoginDto userLoginDto){
        String token = userInfoService.login(userLoginDto);
        return Result.build(token,ResultCodeEnum.SUCCESS);
    }



    // Get user info based on token
    @GetMapping("/getUserInfo")
    public Result getUserInfo(){
        return Result.build(AuthContextUtil.getUserInfo(),ResultCodeEnum.SUCCESS);
    }

    // Log out
    @PostMapping("/logout")
    public Result logout(@RequestHeader(name="token") String token){
        userInfoService.logout(token);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }



}
