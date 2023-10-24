package com.cryptossu.review.section3.springMVC.order;

import com.cryptossu.review.section3.springMVC.order.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
