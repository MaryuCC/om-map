package com.cola.ommap.repository.entity.user;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.cola.ommap.repository.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 实体类对应表 o_user_foot。
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("o_user_foot")
public class UserFoot extends BaseEntity {

    @TableField("user_id")
    private Long userId;

    @TableField("document_id")
    private Long documentId;

    @TableField("document_type")
    private Integer documentType;

    @TableField("document_user_id")
    private Long documentUserId;

    @TableField("collection_stat")
    private Integer collectionStat;

    @TableField("read_stat")
    private Integer readStat;

    @TableField("comment_stat")
    private Integer commentStat;

    @TableField("upvote_stat")
    private Integer upvoteStat;
}