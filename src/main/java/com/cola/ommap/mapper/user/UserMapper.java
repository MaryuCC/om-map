package com.cola.ommap.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cola.ommap.repository.entity.user.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}