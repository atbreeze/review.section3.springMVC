package com.cryptossu.review.section3.springMVC.order.dto;

import com.cryptossu.review.section3.springMVC.order.entity.Order;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderResponseDto {
    private long orderId;
    private long memberId;
    private Order.OrderStatus orderStatus;
    private List<OrderCoffeeResponseDto> orderCoffees;
    private LocalDateTime createdAt;
}
