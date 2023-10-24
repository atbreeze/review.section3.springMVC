package com.cryptossu.review.section3.springMVC.coffee.service;

import com.cryptossu.review.section3.springMVC.coffee.CoffeeRepository;
import com.cryptossu.review.section3.springMVC.coffee.entity.Coffee;
import com.cryptossu.review.section3.springMVC.member.exception.BusinessLogicException;
import com.cryptossu.review.section3.springMVC.member.exception.ExceptionCode;
import com.cryptossu.review.section3.springMVC.order.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CoffeeService {

    private CoffeeRepository coffeeRepository;

    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    public Coffee createCoffee(Coffee coffee) {
//        Coffee createCoffee = coffee;
//        return createCoffee;
        String coffeeCode = coffee.getCoffeeCode().toUpperCase();

        verifyExistsCoffee(coffeeCode);
        coffee.setCoffeeCode(coffeeCode);

        return coffeeRepository.save(coffee);
    }

    public Coffee updateCoffee(Coffee coffee) {
//        Coffee updateCoffee = coffee;
//        return updateCoffee;
        Coffee findCoffee = findVerifiedCoffee(coffee.getCoffeeId());

        Optional.ofNullable(coffee.getKorName())
                .ifPresent(korName -> findCoffee.setKorName(korName));
        Optional.ofNullable(coffee.getEngName())
                .ifPresent(engName -> findCoffee.setEngName(engName));
        Optional.ofNullable(coffee.getPrice())
                .ifPresent(price -> findCoffee.setPrice(price));

        return coffeeRepository.save(findCoffee);
    }

    public Coffee findCoffee(long coffeeId) {
//        Coffee coffee = new Coffee(coffeeId, "아메리카노", "Americano", 4000 );
//        return coffee;
        return findVerifiedCoffeeByQuery(coffeeId);
    }

    public List<Coffee> findOrderedCoffees(Order order) {
        return order.getOrderCoffees()
                .stream()
                .map(orderCoffee -> findCoffee(orderCoffee.getCoffeeId()))
                .collect(Collectors.toList());
    }

    public List<Coffee> findCoffees() {
//        List<Coffee> coffees = List.of(
//                new Coffee(1, "아메리카노", "Americano", 4000),
//                new Coffee(2, "까페라뗴", "CafeLatte",4500)
//        );
//        return coffees;
        return (List<Coffee>) coffeeRepository.findAll();
    }

    public void deleteCoffee(long coffeeId) {
        Coffee coffee = findVerifiedCoffee(coffeeId);
        coffeeRepository.delete(coffee);
    }

    public Coffee findVerifiedCoffee(long coffeeId) {
        Optional<Coffee> optionalCoffee = coffeeRepository.findById(coffeeId);
        Coffee findCoffee = optionalCoffee.orElseThrow(() -> new BusinessLogicException(ExceptionCode.COFFEE_NOT_FOUND));

        return findCoffee;
    }

    private void verifyExistsCoffee(String coffeeCode) {
        Optional<Coffee> optionalCoffee = coffeeRepository.findByCoffeeCode(coffeeCode);
        if(optionalCoffee.isPresent()) throw new BusinessLogicException(ExceptionCode.COFFEE_CODE_EXISTS);
    }

    private Coffee findVerifiedCoffeeByQuery(long coffeeId) {
        Optional<Coffee> optionalCoffee = coffeeRepository.findByCoffee(coffeeId);
        Coffee findCoffee = optionalCoffee.orElseThrow(() -> new BusinessLogicException(ExceptionCode.COFFEE_NOT_FOUND));

        return findCoffee;
    }
}
