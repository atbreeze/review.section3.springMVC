package com.cryptossu.review.section3.springMVC.order;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
//@RequestMapping(value = "/v1/orders", produces = MediaType.APPLICATION_JSON_VALUE)
@RequestMapping(value = "/v1/orders")
public class OrderController {

    @PostMapping
    public ResponseEntity postOrder(@RequestParam("memberId") long memberId,
                                    @RequestParam("coffeeId") long coffeeId) {
//        System.out.println("# memberId : " + memberId);
//        System.out.println("# coffeeId : " + coffeeId);
//
//        String response =
//                "{\"" +
//                        "memberId\":\"" + memberId + "\"," +
//                        "\"coffeeId\":\"" + coffeeId + "\"" +
//                        "}";
//        return response;
        Map<String, Long> map = new HashMap<>();
        map.put("memberId", memberId);
        map.put("coffeeId", coffeeId);

        return new ResponseEntity<>(map, HttpStatus.CREATED);

    }

    @GetMapping("/{order-id}")
    public String getOrder(@PathVariable("order-id") long orderId) {
        System.out.println("# orderId: " + orderId);

//        return null;
    return String.valueOf(new ResponseEntity<>(HttpStatus.OK));
    }


    @GetMapping
    public String getMembers() {
        System.out.println("# get Orders");

//        return null;
        return String.valueOf(new ResponseEntity<>(HttpStatus.OK));
    }
}
