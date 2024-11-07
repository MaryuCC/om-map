package com.cola.ommap.repository.entity.project;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.cola.ommap.repository.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 实体类对应表 o_project_detail。
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("o_project_detail")
public class ProjectDetail extends BaseEntity {

    @TableField("project_id")
    private Long projectId;

    @TableField("content")
    private String content;
}