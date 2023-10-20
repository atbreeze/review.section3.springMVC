package com.cryptossu.review.section3.springMVC.coffee.service;

import com.cryptossu.review.section3.springMVC.coffee.entity.Coffee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeService {

    public Coffee createCoffee(Coffee coffee) {

        Coffee createCoffee = coffee;
        return createCoffee;
    }

    public Coffee updateCoffee(Coffee coffee) {

        Coffee updateCoffee = coffee;
        return updateCoffee;
    }

    public Coffee findCoffee(long coffeeId) {
        Coffee coffee = new Coffee(coffeeId, "아메리카노", "Americano", 4000 );
        return coffee;
    }

    public List<Coffee> findCoffees(){
        List<Coffee> coffees = List.of(
                new Coffee(1, "아메리카노", "Americano", 4000),
                new Coffee(2, "까페라뗴", "CafeLatte",4500)
        );
        return coffees;
    }

    public void deleteCoffee(long coffeeId) {

    }
}
