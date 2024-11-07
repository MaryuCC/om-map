package com.cola.ommap.repository.entity.article;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.cola.ommap.repository.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 实体类对应表 o_article_detail。
 */

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("o_article_detail")
public class ArticleDetail extends BaseEntity {

    @TableField("article_id")
    private Long articleId;

    @TableField("version")
    private Integer version;

    @TableField("content")
    private String content;
}