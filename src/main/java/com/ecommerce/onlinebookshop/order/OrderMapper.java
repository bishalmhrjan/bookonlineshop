package com.ecommerce.onlinebookshop.order;

import com.ecommerce.onlinebookshop.order.OrderDto;
import com.ecommerce.onlinebookshop.model.entity.Order;

public class OrderMapper {

    public static OrderDto mapToOrderDto(Order order){

        OrderDto orderDto = OrderDto.builder()
                .id(order.getId())
                .amount(order.getAmount())
                .shippingAddress(order.getShippingAddress())
                .billingAddress(order.getBillingAddress())
                .historyCart(order.getHistoryCart())
                .build();
        return orderDto;
    }

    public static Order mapToOrder(OrderDto orderDto){
        Order order = Order.builder()
                .id(orderDto.getId())
                .amount(orderDto.getAmount())
                .shippingAddress(orderDto.getShippingAddress())
                .billingAddress(orderDto.getBillingAddress())
                .historyCart(orderDto.getHistoryCart())
                .build();
        return order;
    }
}
