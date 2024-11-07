package com.cola.ommap.repository.entity.gift;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.cola.ommap.repository.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Date;

/**
 * 实体类对应表 o_gift。
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("o_gift")
public class Gift extends BaseEntity {

    @TableField("gift_name")
    private String giftName;

    @TableField("description")
    private String description;

    @TableField("stock")
    private Integer stock;

    @TableField("price")
    private Integer price;

    @TableField("status")
    private Integer status;

    @TableField("valid_date")
    private Date validDate;
}