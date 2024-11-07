package com.cola.ommap.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cola.ommap.exception.OmException;
import com.cola.ommap.mapper.user.UserInfoMapper;
import com.cola.ommap.mapper.user.UserMapper;
import com.cola.ommap.repository.dto.h5.UserLoginDto;
import com.cola.ommap.repository.dto.h5.UserRegisterDto;
import com.cola.ommap.repository.entity.user.User;
import com.cola.ommap.repository.entity.user.UserInfo;
import com.cola.ommap.repository.vo.common.ResultCodeEnum;
import com.cola.ommap.repository.vo.h5.UserVo;
import com.cola.ommap.service.UserInfoService;
import com.cola.ommap.utils.AuthContextUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.sql.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


import static com.cola.ommap.constant.RedisConstant.Email_Pre;
import static com.cola.ommap.constant.RedisConstant.Login_Token_Pre;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;


    @Override
    public void register(UserRegisterDto userRegisterDto) {
        // 1 userRegisterDto获取数据
        String email = userRegisterDto.getEmail();
        String password = userRegisterDto.getPassword();
        String nickName = userRegisterDto.getNickName();
        String code = userRegisterDto.getCode();


        // 2 验证码校验
        if(!isValidate(email,code)){
            throw new OmException(ResultCodeEnum.VALIDATECODE_ERROR);
        }

        // 3 校验用户名不能重复
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>()
                                            .eq(User::getEmail, email)
                                            .eq(User::getDeleted,0));
        if(user != null){ //存在相同用户名
            throw new OmException(ResultCodeEnum.USER_NAME_IS_EXISTS);
        }

        // 4 封装添加数据，调用方法添加数据库
        user = new User();
        user.setEmail(email);
        user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        user.setNickName(nickName);

        userMapper.insert(user);

        // 5 从redis中删除发送的验证码
        redisTemplate.delete(email);
    }

    @Override
    public String login(UserLoginDto userLoginDto) {
        // 1. Dto获取用户名和密码
        String email = userLoginDto.getEmail();
        String password = userLoginDto.getPassword();

        // 2. 根据用户名查询数据库，得到用户信息
        User user = userMapper.selectOne(new LambdaQueryWrapper<User>()
                                            .eq(User::getEmail, email));

        // 3. 比较密码是否一致
        String database_password = user.getPassword();
        String md5_password = DigestUtils.md5DigestAsHex(password.getBytes());
        if(!database_password.equals(md5_password)){
            throw new OmException(ResultCodeEnum.LOGIN_ERROR);
        }

        // 校验用户是否被禁用

        // 4. 生成token
        String token = UUID.randomUUID().toString().replaceAll("-", "");

        // 5. 把用户信息放到redis中
        redisTemplate.opsForValue().set(Login_Token_Pre+token,
                JSON.toJSONString(user),60, TimeUnit.MINUTES);

        // 返回token
        return token;
    }

    @Override
    public void logout(String token) {

    }

    @Override
    public UserVo getCurrentUserInfo(String token) {
        User user = AuthContextUtil.getUserInfo();


        UserVo userVo = new UserVo();
        BeanUtils.copyProperties(user,userVo);
        return userVo;
    }

    //验证码校验
    private boolean isValidate(String userName, String code){
        // 2，1 从redis获取发送验证码
        String redisCode = redisTemplate.opsForValue().get(Email_Pre + userName);
        if(redisCode == null){
            throw new  OmException(ResultCodeEnum.VALIDATECODE_TIMEOUT);
        }

        // 2.2 获取输入的验证码，进行比对
        if(redisCode.equals(code)){
            return true;
        }
        return false;
    }

    // update avatar
    @Override
    public void updateAvatar(String photo) {
        User user = AuthContextUtil.getUserInfo();
        UserInfo userInfo = userInfoMapper.selectOne(new LambdaQueryWrapper<UserInfo>()
                                                            .eq(UserInfo::getUserId,user.getId()));
        userInfo.setPhoto(photo);
        userInfoMapper.updateById(userInfo);
    }

    // update username
    @Override
    public void updateUsername(String userName) {
        User user = AuthContextUtil.getUserInfo();
        user.setNickName(userName);
        userMapper.updateById(user);
    }

    // update gender
    @Override
    public void updateGender(Integer gender) {
        User user = AuthContextUtil.getUserInfo();
        UserInfo userInfo = userInfoMapper.selectOne(new LambdaQueryWrapper<UserInfo>()
                .eq(UserInfo::getUserId,user.getId()));
        userInfo.setGender(gender);
        userInfoMapper.updateById(userInfo);
    }

    // update pronoun
    @Override
    public void updatePronoun(Integer pronoun) {
        User user = AuthContextUtil.getUserInfo();
        UserInfo userInfo = userInfoMapper.selectOne(new LambdaQueryWrapper<UserInfo>()
                .eq(UserInfo::getUserId,user.getId()));
        userInfo.setPronoun(pronoun);
        userInfoMapper.updateById(userInfo);
    }

    // update birthday
    @Override
    public void updateBirthday(Date birthday) {
        User user = AuthContextUtil.getUserInfo();
        UserInfo userInfo = userInfoMapper.selectOne(new LambdaQueryWrapper<UserInfo>()
                .eq(UserInfo::getUserId,user.getId()));
        userInfo.setBirthday(birthday);
        userInfoMapper.updateById(userInfo);
    }

    // update password
    @Override
    public void updatePasswd(String passwd) {
        User user = AuthContextUtil.getUserInfo();
        user.setPassword(passwd);
        userMapper.updateById(user);
    }
}
