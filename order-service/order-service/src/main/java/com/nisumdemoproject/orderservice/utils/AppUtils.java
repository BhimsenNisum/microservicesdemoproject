package com.nisumdemoproject.orderservice.utils;

import com.nisumdemoproject.orderservice.dto.OrderDto;
import com.nisumdemoproject.orderservice.entity.Order;
import org.springframework.beans.BeanUtils;

public class AppUtils {
    public static OrderDto entityToDto(Order order){
        OrderDto orderDto = new OrderDto();
        BeanUtils.copyProperties(order,orderDto);
        return orderDto;
    }

    public static Order dtoToEntity(OrderDto orderDto){
        Order order = new Order();
        BeanUtils.copyProperties(orderDto,order);
        return order;
    }
}
