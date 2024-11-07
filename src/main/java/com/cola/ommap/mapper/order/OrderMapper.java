package com.cola.ommap.mapper.order;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cola.ommap.repository.entity.order.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
