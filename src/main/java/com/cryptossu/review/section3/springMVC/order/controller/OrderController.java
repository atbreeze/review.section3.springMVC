package com.cryptossu.review.section3.springMVC.order.controller;

import com.cryptossu.review.section3.springMVC.coffee.service.CoffeeService;
import com.cryptossu.review.section3.springMVC.order.dto.OrderResponseDto;
import com.cryptossu.review.section3.springMVC.order.entity.Order;
import com.cryptossu.review.section3.springMVC.order.dto.OrderPostDto;
import com.cryptossu.review.section3.springMVC.order.mapstruct.OrderMapper;
import com.cryptossu.review.section3.springMVC.order.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
//@RequestMapping(value = "/v1/orders", produces = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping(value = "/v10/orders")
@Validated
public class OrderController {
    private final static String ORDER_DEFAULT_URL = "/v10/orders";
    private final OrderService orderService;
    private final OrderMapper orderMapper;
    private final CoffeeService coffeeService;

    public OrderController(OrderService orderService, OrderMapper orderMapper, CoffeeService coffeeService) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
        this.coffeeService = coffeeService;
    }

    @PostMapping
//    public ResponseEntity postOrder(@RequestParam("memberId") long memberId,
//                                    @RequestParam("coffeeId") long coffeeId) {
////        System.out.println("# memberId : " + memberId);
////        System.out.println("# coffeeId : " + coffeeId);
////
////        String response =
////                "{\"" +
////                        "memberId\":\"" + memberId + "\"," +
////                        "\"coffeeId\":\"" + coffeeId + "\"" +
////                        "}";
////        return response;
//        Map<String, Long> map = new HashMap<>();
//        map.put("memberId", memberId);
//        map.put("coffeeId", coffeeId);
//
//        return new ResponseEntity<>(map, HttpStatus.CREATED);
    public ResponseEntity postOrder(@Valid @RequestBody OrderPostDto orderPostDto) {
        Order order = orderService.createOrder(orderMapper.orderPostDtoToOrder(orderPostDto));

        URI location =
                UriComponentsBuilder
                        .newInstance()
                        .path(ORDER_DEFAULT_URL + "{order-id}")
                        .buildAndExpand(order.getOrderId())
                        .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{order-id}")
    public String getOrder(@PathVariable("order-id") @Positive long orderId) {
//        System.out.println("# orderId: " + orderId);
//        return null;
//        return String.valueOf(new ResponseEntity<>(HttpStatus.OK));
        Order order = orderService.findOrder(orderId);

        return String.valueOf(new ResponseEntity<>(orderMapper.orderToOrderResponseDto(coffeeService, order), HttpStatus.OK));

    }

    @GetMapping
    public String getOrders() {
//        System.out.println("# get Orders");
//        return null;
//        return String.valueOf(new ResponseEntity<>(HttpStatus.OK));
        List<Order> orders = orderService.findOrders();
        List<OrderResponseDto> response = orders.stream()
                .map(order -> orderMapper.orderToOrderResponseDto(coffeeService, order))
                .collect(Collectors.toList());

        return String.valueOf(new ResponseEntity<>(response, HttpStatus.OK));
    }

    @DeleteMapping("{order-id}")
public ResponseEntity cancelOrder(@PathVariable("order-id") @Positive long orderId) {
        orderService.cancelOrder(orderId);
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }
}
