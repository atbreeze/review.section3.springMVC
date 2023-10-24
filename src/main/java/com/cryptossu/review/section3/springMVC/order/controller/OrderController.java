package com.cryptossu.review.section3.springMVC.order.controller;

import com.cryptossu.review.section3.springMVC.coffee.service.CoffeeService;
import com.cryptossu.review.section3.springMVC.order.entity.Order;
import com.cryptossu.review.section3.springMVC.order.dto.OrderPostDto;
import com.cryptossu.review.section3.springMVC.order.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
        Order order = orderService.createOrder(mapper.orderPostDtoToOrder(orderPostDto));
    }

    @GetMapping("/{order-id}")
    public String getOrder(@PathVariable("order-id") long orderId) {
        System.out.println("# orderId: " + orderId);

//        return null;
    return String.valueOf(new ResponseEntity<>(HttpStatus.OK));
    }


    @GetMapping
    public String getMembers() {
        System.out.println("# get Orders");

//        return null;
        return String.valueOf(new ResponseEntity<>(HttpStatus.OK));
    }
}
