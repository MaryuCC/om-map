package com.cola.ommap.repository.entity.base;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class BaseEntity {

    @TableField("id")
    private Long id;

    @TableField("deleted")
    private Integer deleted;

    @TableField(value = "create_time")
    private Timestamp createTime;

    @TableField(value = "update_time")
    private Timestamp updateTime;
}