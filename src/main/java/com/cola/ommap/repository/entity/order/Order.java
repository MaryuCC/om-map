package com.cola.ommap.repository.entity.order;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;
import com.cola.ommap.repository.entity.base.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 实体类对应表 o_order。
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("o_order")
public class Order extends BaseEntity {

    @TableField("order_no")
    private String orderNo;

    @TableField("project_id")
    private Long projectId;

    @TableField("customer_id")
    private Long customerId;

    @TableField("customer_name")
    private String customerName;

    @TableField("original_price")
    private BigDecimal originalPrice;

    @TableField("total_price")
    private BigDecimal totalPrice;

    @TableField("status")
    private Integer status;

    @TableField("cancel_time")
    private LocalDateTime cancelTime;
}