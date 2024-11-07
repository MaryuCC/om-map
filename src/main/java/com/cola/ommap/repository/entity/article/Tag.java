package com.cola.ommap.repository.entity.article;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.cola.ommap.repository.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 实体类对应表 o_tag。
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("o_tag")
public class Tag extends BaseEntity {

    @TableField("tag_name")
    private String tagName;

    @TableField("tag_type")
    private Integer tagType;

    @TableField("status")
    private Integer status;
}