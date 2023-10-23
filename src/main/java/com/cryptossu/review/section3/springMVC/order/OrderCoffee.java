package com.cryptossu.review.section3.springMVC.order;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table("ORDER_COFFEE")
public class OrderCoffee {
    @Id
    private long orderCoffeeId;
    private long coffeeId;
    private int quantity;

}
