package com.cryptossu.review.section3.springMVC.order.service;

import com.cryptossu.review.section3.springMVC.coffee.service.CoffeeService;
import com.cryptossu.review.section3.springMVC.member.exception.BusinessLogicException;
import com.cryptossu.review.section3.springMVC.member.exception.ExceptionCode;
import com.cryptossu.review.section3.springMVC.member.service.MemberService;
import com.cryptossu.review.section3.springMVC.order.entity.Order;
import com.cryptossu.review.section3.springMVC.order.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    final private OrderRepository orderRepository;
    final private MemberService memberService;
    final private CoffeeService coffeeService;

    public OrderService(OrderRepository orderRepository, MemberService memberService, CoffeeService coffeeService) {
        this.orderRepository = orderRepository;
        this.memberService = memberService;
        this.coffeeService = coffeeService;
    }

    public Order createOrder(Order order) {
        memberService.findVerifiedMember(order.getMemberId());

        order.getOrderCoffees()
                .stream()
                .forEach(orderCoffee -> {
                    coffeeService.findVerifiedCoffee(orderCoffee.getCoffeeId());
                });

        return orderRepository.save(order);
    }

    public Order findOrder(long orderId) {
        return findVerifiedOrder(orderId);
    }

    public List<Order> findOrders() {
        return (List<Order>) orderRepository.findAll();
    }

    public void cancelOrder (long orderId) {
        Order findOrder = findVerifiedOrder(orderId);
        int step = findOrder.getOrderStatus().getStepNumber();

        if (step >= 2) {
            throw new BusinessLogicException(ExceptionCode.CANNOT_CHANGE_ORDER);
        }

        findOrder.setOrderStatus(Order.OrderStatus.ORDER_CANCEL);
        orderRepository.save(findOrder);
    }

    private Order findVerifiedOrder(long orderId) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        Order findOrder = optionalOrder.orElseThrow(() -> new BusinessLogicException(ExceptionCode.ORDER_NOT_FOUND));
        return findOrder;
    }
}
