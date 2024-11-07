package com.cola.ommap.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cola.ommap.mapper.order.OrderMapper;
import com.cola.ommap.repository.entity.order.Order;
import com.cola.ommap.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
}
