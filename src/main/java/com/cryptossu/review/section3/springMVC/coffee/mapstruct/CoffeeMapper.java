package com.cryptossu.review.section3.springMVC.coffee.mapstruct;

import com.cryptossu.review.section3.springMVC.coffee.dto.CoffeePatchDTO;
import com.cryptossu.review.section3.springMVC.coffee.dto.CoffeePostDTO;
import com.cryptossu.review.section3.springMVC.coffee.dto.CoffeeResponseDto;
import com.cryptossu.review.section3.springMVC.coffee.entity.Coffee;
import org.mapstruct.Mapper;

import java.lang.reflect.Member;

@Mapper(componentModel = "spring")
public interface CoffeeMapper {
    Coffee coffePostDtoToCoffee(CoffeePostDTO coffeePostDTO);
    Coffee coffeePatchDtoToCoffee(CoffeePatchDTO coffeePatchDTO);
    CoffeeResponseDto coffeeToCoffeeResponseDto(Coffee coffee);

}
