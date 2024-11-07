package com.cola.ommap.repository.entity.System;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.cola.ommap.repository.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 实体类对应表 o_notify_msg。
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("o_notify_msg")
public class NotifyMsg extends BaseEntity {

    @TableField("related_id")
    private Long relatedId;

    @TableField("notify_user_id")
    private Long notifyUserId;

    @TableField("operate_user_id")
    private Long operateUserId;

    @TableField("msg")
    private String msg;

    @TableField("type")
    private Integer type;

    @TableField("state")
    private Integer state;
}