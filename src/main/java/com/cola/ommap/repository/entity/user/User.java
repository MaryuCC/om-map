package com.cola.ommap.repository.entity.user;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.cola.ommap.repository.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 实体类对应表 o_user。
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("o_user")
public class User extends BaseEntity {

    @TableField("email")
    private String email;

    @TableField("password")
    private String password;

    @TableField("nick_name")
    private String nickName;
}