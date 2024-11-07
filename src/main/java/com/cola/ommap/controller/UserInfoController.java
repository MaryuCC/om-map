package com.cola.ommap.controller;


import com.cola.ommap.repository.vo.common.Result;
import com.cola.ommap.repository.vo.common.ResultCodeEnum;
import com.cola.ommap.repository.vo.h5.UserVo;
import com.cola.ommap.service.UserInfoService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

import static com.cola.ommap.utils.ExtractHeaderUtil.extractToken;

@Slf4j
@RestController
@RequestMapping("/api/auth/user")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    // get current user info
    @GetMapping("auth/getCurrentUserInfo")
    public Result getCurrentUserInfo(HttpServletRequest request){
        String token = extractToken(request);
        UserVo userVo = userInfoService.getCurrentUserInfo(token);
        return Result.build(userVo, ResultCodeEnum.SUCCESS);
    }

    // update avatar
    @PostMapping("/updateAvatar/{avatar}")
    public Result updateAvatar(@PathVariable String avatar){
        userInfoService.updateAvatar(avatar);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }

    // update username
    @PostMapping("/updateUsername/{userName}")
    public Result updateUsername(@PathVariable String userName){
        userInfoService.updateUsername(userName);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }

    // gender
    @PostMapping("/updateGender/{gender}")
    public Result updateGender(@PathVariable Integer gender){
        userInfoService.updateGender(gender);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }

    // pronoun
    @PostMapping("/updatePronoun/{pronoun}")
    public Result updatePronoun(@PathVariable Integer pronoun){
        userInfoService.updatePronoun(pronoun);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }

    // birthday
    @PostMapping("/updateBirthday/{birthday}")
    public Result updateBirthday(@PathVariable Date birthday){
        userInfoService.updateBirthday(birthday);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }

    //TODO Email


    // password
    @PostMapping("/updatePasswd/{passwd}")
    public Result updatePasswd(@PathVariable String passwd){
        userInfoService.updatePasswd(passwd);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }


}
