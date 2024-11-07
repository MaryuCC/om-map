package com.cola.ommap.mapper.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cola.ommap.repository.entity.user.UserInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
}
