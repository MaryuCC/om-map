package com.cola.ommap.repository.entity.article;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.cola.ommap.repository.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 实体类对应表 o_read_count。
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("o_read_count")
public class ReadCount extends BaseEntity {

    @TableField("document_id")
    private Long documentId;

    @TableField("document_type")
    private Integer documentType;

    @TableField("cnt")
    private Integer cnt;
}