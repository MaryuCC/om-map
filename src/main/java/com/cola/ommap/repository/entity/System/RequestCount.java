package com.cola.ommap.repository.entity.System;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.cola.ommap.repository.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

/**
 * 实体类对应表 o_request_count。
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("o_request_count")
public class RequestCount extends BaseEntity {

    @TableField("host")
    private String host;

    @TableField("cnt")
    private Integer cnt;

    @TableField("date")
    private LocalDate date;
}