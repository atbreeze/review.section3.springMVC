package com.cryptossu.review.section3.springMVC.coffee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@RestController
//@RequestMapping(value = "/v1/coffees", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequestMapping(value = "/v1/coffees")
public class CoffeeController {

    private final Map<Long, Map<String, Object>> coffees = new HashMap<>();

    @PostConstruct
    public void init() {
        Map<String, Object> coffee1 = new HashMap<>();
        long coffeeId = 1L;
        coffee1.put("coffeeId", coffeeId);
        coffee1.put("korName", "바닐라 라떼");
        coffee1.put("engName", "Vanilla Latte");
        coffee1.put("price", 4500);

        coffees.put(coffeeId, coffee1);
    }

    @PostMapping
    public ResponseEntity postCoffee(@RequestParam("korName") String korName,
                                     @RequestParam("engName") String engName,
                                     @RequestParam("price") int price
    ) {
//        System.out.println("# korName : " + korName);
//        System.out.println("# name : " + engName);
//        System.out.println("# phone : " + price);

//        String response =
//                "{\"" +
//                        "email\":\"" + korName + "\"," +
//                        "\"name\":\"" + engName + "\",\"" +
//                        "phone\":\"" + price +
//                        "\"}";
//        return response;
        Map<String, String> map = new HashMap<>();
        String pricetoString = String.valueOf(price);

        map.put("korName", korName);
        map.put("engName", engName);
        map.put("price", pricetoString);

        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id") long coffeeId) {
        System.out.println("# coffeeId: " + coffeeId);

//        return null;
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getCoffees() {
        System.out.println("# get Coffees");

//        return null;
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{coffee-id}")
    public ResponseEntity patchCoffee(@PathVariable("coffee-id") long coffeeId){

        coffees.get(coffeeId).put("korName", "바닐라 빈 라떼");
        coffees.get(coffeeId).put("price", 5000);

        return new ResponseEntity<>(coffees.get(coffeeId), HttpStatus.CREATED);
    }

    @DeleteMapping("/{coffee-id}")
    public ResponseEntity deleteCoffee(@PathVariable("coffee-id") long coffeeId){
        coffees.remove(coffeeId);
        return new ResponseEntity<>(coffees.get(coffeeId), HttpStatus.NO_CONTENT);
    }
}
