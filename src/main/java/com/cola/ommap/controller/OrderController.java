package com.cola.ommap.controller;

import com.cola.ommap.repository.entity.order.Order;
import com.cola.ommap.repository.vo.common.Result;
import com.cola.ommap.repository.vo.common.ResultCodeEnum;
import com.cola.ommap.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/api/order/")
public class OrderController {
    @Autowired
    OrderService orderService;

    // TODO 生成订单
    @PostMapping("auth/submitOrder")
    public Result submitOrder(@RequestBody OrderDto orderDto){
        Long id = orderService.submitOrder(orderDto);
        return Result.build(id, ResultCodeEnum.SUCCESS);
    }


    // 获取订单分页列表
    @GetMapping("auth/{page}/{limit}")
    public Result list(@PathVariable Integer page,
                                        @PathVariable Integer limit,
                                        @RequestParam(required = false, defaultValue = "") Integer orderStatus){
        PageInfo<Order> pageInfo = orderService.findOrderByPage(page,limit,orderStatus);
        return Result.build(pageInfo, ResultCodeEnum.SUCCESS);
    }


    // TODO finish missiondto and update service
    // TODO 订单完成
    @PostMapping("auth/missionComplete")
    public Result missionComplete(@PathVariable Long orderId
                                  //,@RequestBody MissionDto missionDto
    ){
        orderService.missionComplete(orderId);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }

    // TODO 订单完成确认
    @PostMapping("auth/completeOrder")
    public Result completeOrder(@PathVariable Long orderId){
        orderService.completeOrder(orderId);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }

    // TODO 订单取消
    @PostMapping("auth/cancelOrder")
    public Result cancelOrder(@PathVariable Long orderId){
        orderService.cancelOrder(orderId);
        return Result.build(null, ResultCodeEnum.SUCCESS);
    }
}
