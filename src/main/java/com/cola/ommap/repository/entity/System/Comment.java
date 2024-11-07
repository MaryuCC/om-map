package com.cola.ommap.repository.entity.base;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 实体类对应表 o_comment。
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("o_comment")
public class Comment extends BaseEntity {

    @TableField("article_id")
    private Long articleId;

    @TableField("user_id")
    private Long userId;

    @TableField("content")
    private String content;

    @TableField("top_comment_id")
    private Long topCommentId;

    @TableField("parent_comment_id")
    private Long parentCommentId;
}