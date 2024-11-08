package com.cola.ommap.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cola.ommap.repository.dto.h5.UserLoginDto;
import com.cola.ommap.repository.dto.h5.UserRegisterDto;
import com.cola.ommap.repository.entity.user.UserInfo;
import com.cola.ommap.repository.vo.common.RolesEnum;
import com.cola.ommap.repository.vo.h5.UserVo;

import java.nio.file.FileStore;
import java.sql.Date;

public interface UserInfoService extends IService<UserInfo> {
    void register(UserRegisterDto userRegisterDto);

    String login(UserLoginDto userLoginDto);

    void logout(String token);

    UserVo getCurrentUserInfo(String token);

    void updateAvatar(String avatar);

    void updateUsername(String userName);

    void updateGender(Integer gender);

    void updatePronoun(Integer pronoun);

    void updateBirthday(Date birthday);

    void updatePasswd(String passwd);

    RolesEnum getUserRoleByUserId(Long id);
}
