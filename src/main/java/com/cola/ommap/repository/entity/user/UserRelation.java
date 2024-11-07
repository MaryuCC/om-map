package com.cola.ommap.repository.entity.user;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.cola.ommap.repository.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * 实体类对应表 o_user_relation。
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("o_user_relation")
public class UserRelation extends BaseEntity {

    @TableField("user_id")
    private Long userId;

    @TableField("follow_user_id")
    private Long followUserId;

    @TableField("follow_state")
    private Integer followState;

    @TableField("creat_time") // 注意：'creat_time' 似乎是拼写错误，建议在数据库中更正为 'create_time'
    private LocalDateTime creatTime;
}