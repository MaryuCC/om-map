package com.cola.ommap.repository.entity.shop;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.cola.ommap.repository.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 实体类对应表 o_shop。
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("o_shop")
public class Shop extends BaseEntity {

    @TableField("name")
    private String name;

    @TableField("type")
    private Integer type;

    @TableField("address")
    private String address;

    @TableField("phone_number")
    private String phoneNumber;

    @TableField("short_description")
    private String shortDescription;

    @TableField("place_id")
    private String placeId;
}