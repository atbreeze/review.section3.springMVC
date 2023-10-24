package com.cryptossu.review.section3.springMVC.order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class OrderCoffeeResponseDto {

    private long coffeeId;
    private String korName;
    private String engName;
    private int price;
    private int quantity;

}
