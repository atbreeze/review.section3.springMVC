package com.cryptossu.review.section3.springMVC.coffee.controller;

import com.cryptossu.review.section3.springMVC.coffee.dto.CoffeePatchDTO;
import com.cryptossu.review.section3.springMVC.coffee.dto.CoffeePostDTO;
import com.cryptossu.review.section3.springMVC.coffee.dto.CoffeeResponseDto;
import com.cryptossu.review.section3.springMVC.coffee.entity.Coffee;
import com.cryptossu.review.section3.springMVC.coffee.mapstruct.CoffeeMapper;
import com.cryptossu.review.section3.springMVC.coffee.service.CoffeeService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
//@RequestMapping(value = "/v1/coffees", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequestMapping(value = "/v5/coffees")
@Validated
public class CoffeeController {
//    private final Map<Long, Map<String, Object>> coffees = new HashMap<>();
//
//    @PostConstruct
//    public void init() {
//        Map<String, Object> coffee1 = new HashMap<>();
//        long coffeeId = 1L;
//        coffee1.put("coffeeId", coffeeId);
//        coffee1.put("korName", "바닐라 라떼");
//        coffee1.put("engName", "Vanilla Latte");
//        coffee1.put("price", 4500);
//
//        coffees.put(coffeeId, coffee1);
//    }
    //    public ResponseEntity postCoffee(@RequestParam("korName") String korName,
//                                     @RequestParam("engName") String engName,
//                                     @RequestParam("price") int price
//    ) {
////        System.out.println("# korName : " + korName);
////        System.out.println("# name : " + engName);
////        System.out.println("# phone : " + price);
//
////        String response =
////                "{\"" +
////                        "email\":\"" + korName + "\"," +
////                        "\"name\":\"" + engName + "\",\"" +
////                        "phone\":\"" + price +
////                        "\"}";
////        return response;
//        Map<String, String> map = new HashMap<>();
//        String pricetoString = String.valueOf(price);
//
//        map.put("korName", korName);
//        map.put("engName", engName);
//        map.put("price", pricetoString);
//
//        return new ResponseEntity<>(map, HttpStatus.CREATED);
//    }
    private final CoffeeService coffeeService;
    private final CoffeeMapper coffeeMapper;

    public CoffeeController(CoffeeService coffeeService, CoffeeMapper coffeeMapper){
        this.coffeeService = coffeeService;
        this.coffeeMapper = coffeeMapper;
    }
    @PostMapping
    public ResponseEntity postCoffee(@Valid @RequestBody CoffeePostDTO coffeePostDTO) {

        Coffee coffee = coffeeMapper.coffePostDtoToCoffee(coffeePostDTO);
        Coffee response = coffeeService.createCoffee(coffee);

        return new ResponseEntity<>(coffeeMapper.coffeeToCoffeeResponseDto(response), HttpStatus.CREATED);
    }

    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id") long coffeeId) {

        Coffee response = coffeeService.findCoffee(coffeeId);

//        return null;
        return new ResponseEntity<>(coffeeMapper.coffeeToCoffeeResponseDto(response), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getCoffees() {

        List<Coffee> coffees = coffeeService.findCoffees();
        List<CoffeeResponseDto> response =
                coffees.stream()
                        .map(coffee -> coffeeMapper.coffeeToCoffeeResponseDto(coffee))
                        .collect(Collectors.toList());

//        return null;
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping("/{coffee-id}")
//    public ResponseEntity patchCoffee(@PathVariable("coffee-id") long coffeeId){
//
//        coffees.get(coffeeId).put("korName", "바닐라 빈 라떼");
//        coffees.get(coffeeId).put("price", 5000);
//
//        return new ResponseEntity<>(coffees.get(coffeeId), HttpStatus.CREATED);
//    }

    public ResponseEntity patchCoffee(@PathVariable("coffee-id") @Min(1) long coffeeId,
                                      @Valid @RequestBody CoffeePatchDTO coffeePatchDTO) {
        coffeePatchDTO.setCoffeeId(coffeeId);

        Coffee response = coffeeService.updateCoffee(coffeeMapper.coffeePatchDtoToCoffee(coffeePatchDTO));

        return new ResponseEntity<>(coffeeMapper.coffeeToCoffeeResponseDto(response), HttpStatus.CREATED);
    }

    @DeleteMapping("/{coffee-id}")
    public ResponseEntity deleteCoffee(@PathVariable("coffee-id") long coffeeId) {
//        coffees.remove(coffeeId);
//        return new ResponseEntity<>(coffees.get(coffeeId), HttpStatus.NO_CONTENT);
        coffeeService.deleteCoffee(coffeeId);

        return new ResponseEntity<>(coffeeId, HttpStatus.NO_CONTENT);
    }
}
