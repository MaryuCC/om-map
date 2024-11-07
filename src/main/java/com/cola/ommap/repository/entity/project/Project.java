package com.cola.ommap.repository.entity.project;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.cola.ommap.repository.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

/**
 * 实体类对应表 o_project。
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("o_project")
public class Project extends BaseEntity {

    @TableField("host_id")
    private Long hostId;

    @TableField("project_name")
    private String projectName;

    @TableField("project_address")
    private String projectAddress;

    @TableField("project_price")
    private BigDecimal projectPrice;
}