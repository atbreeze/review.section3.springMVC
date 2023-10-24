package com.cryptossu.review.section3.springMVC.order.dto;

import com.cryptossu.review.section3.springMVC.order.dto.OrderCoffeeDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@Getter
@AllArgsConstructor
public class OrderPostDto {
    @Positive
    private long memberId;

    @Valid
    private List<OrderCoffeeDto> orderCoffees;
}