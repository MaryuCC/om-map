package com.cola.ommap.repository.entity.user;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.cola.ommap.repository.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Date;

/**
 * 实体类对应表 o_user_info。
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("o_user_info")
public class UserInfo extends BaseEntity {

    @TableField("user_id")
    private Long userId;

    @TableField("gender")
    private Integer gender;

    @TableField("pronoun")
    private Integer pronoun;

    @TableField("om_value")
    private Integer omValue;

    @TableField("credit")
    private Integer credit;

    @TableField("photo")
    private String photo;

    @TableField("my_position")
    private String myPosition;

    @TableField("university")
    private String university;

    @TableField("profile")
    private String profile;

    @TableField("user_role")
    private Integer userRole;

    @TableField("birthday")
    private Date birthday;

    @TableField("qrcode")
    private String qrcode;
}