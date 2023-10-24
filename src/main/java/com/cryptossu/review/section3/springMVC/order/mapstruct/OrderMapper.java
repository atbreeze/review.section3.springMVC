package com.cryptossu.review.section3.springMVC.order.mapstruct;

import com.cryptossu.review.section3.springMVC.coffee.entity.Coffee;
import com.cryptossu.review.section3.springMVC.coffee.service.CoffeeService;
import com.cryptossu.review.section3.springMVC.order.OrderCoffee;
import com.cryptossu.review.section3.springMVC.order.dto.OrderCoffeeDto;
import com.cryptossu.review.section3.springMVC.order.dto.OrderCoffeeResponseDto;
import com.cryptossu.review.section3.springMVC.order.dto.OrderPostDto;
import com.cryptossu.review.section3.springMVC.order.dto.OrderResponseDto;
import com.cryptossu.review.section3.springMVC.order.entity.Order;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    default Order orderPostDtoToOrder(OrderPostDto orderPostDto) {
        Order order = new Order();

        order.setMemberId(orderPostDto.getMemberId());

        Set<OrderCoffee> orderCoffees = orderPostDto.getOrderCoffees()
                .stream()
                .map(orderCoffeeDto ->
                        OrderCoffee.builder()
                                .coffeeId(orderCoffeeDto.getCoffeeId())
                                .quantity(orderCoffeeDto.getQuantity())
                                .build())
                .collect(Collectors.toSet());
                order.setOrderCoffees(orderCoffees);

                return order;
    }

    default OrderResponseDto orderToOrderResponseDto(CoffeeService coffeeService, Order order) {

        long memberId = order.getMemberId();

        List<OrderCoffeeResponseDto> orderCoffees = orderCoffeesToOderCoffeeResponseDtos(coffeeService, order.getOrderCoffees());

        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setOrderCoffees(orderCoffees);
        orderResponseDto.setMemberId(memberId);
        orderResponseDto.setCreatedAt(order.getCreatedAt());
        orderResponseDto.setOrderId(order.getOrderId());
        orderResponseDto.setOrderStatus(order.getOrderStatus());

        return orderResponseDto;
    }

    default List<OrderCoffeeResponseDto> orderCoffeesToOderCoffeeResponseDtos(CoffeeService coffeeService, Set<OrderCoffee> orderCoffees) {
        return orderCoffees.stream()
                .map(orderCoffee -> {
                    Coffee coffee = coffeeService.findCoffee(orderCoffee.getCoffeeId());

                    return new OrderCoffeeResponseDto(coffee.getCoffeeId(),
                            coffee.getKorName(),
                            coffee.getEngName(),
                            coffee.getPrice(),
                            orderCoffee.getQuantity());
                }).collect(Collectors.toList());
    }
}
