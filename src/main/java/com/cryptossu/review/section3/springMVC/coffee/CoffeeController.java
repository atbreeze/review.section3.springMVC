package com.cryptossu.review.section3.springMVC.coffee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
//@RequestMapping(value = "/v1/coffees", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequestMapping(value = "/v1/coffees")
public class CoffeeController {

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
}
