package com.cola.ommap.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cola.ommap.mapper.user.UserMapper;
import com.cola.ommap.repository.entity.user.User;
import com.cola.ommap.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
