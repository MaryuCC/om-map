package com.cola.ommap.repository.entity.article;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.cola.ommap.repository.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
@TableName("o_article")
public class Article extends BaseEntity {

    @TableField("user_id")
    private Long userId;

    @TableField("article_type")
    private Integer articleType;

    @TableField("title")
    private String title;

    @TableField("short_title")
    private String shortTitle;

    @TableField("picture")
    private String picture;

    @TableField("summary")
    private String summary;

    @TableField("topping_stat")
    private Integer toppingStat;

    @TableField("status")
    private Integer status;
}