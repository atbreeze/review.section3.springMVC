package com.cryptossu.review.section3.springMVC.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController

//@RequestMapping(value = "/v1/members", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequestMapping(value = "/v1/members")
public class MemberController {

    @PostMapping
    public ResponseEntity postMember(@RequestParam("email") String email,
                             @RequestParam("name") String name,
                             @RequestParam("phone") String phone) {
//        System.out.println("# email : " + email);
//        System.out.println("# name : " + name);
//        System.out.println("# phone : " + phone);
//
//        String response =
//                "{\"" +
//                        "email\":\"" + email + "\"," +
//                        "\"name\":\"" + name + "\",\"" +
//                        "phone\":\"" + phone +
//                        "\"}";
//        return response;
        Map<String, String> map = new HashMap<>();

        map.put("email", email);
        map.put("name", name);
        map.put("phone", phone);

        return new ResponseEntity<> (map, HttpStatus.CREATED);
    }

    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") long memberId) {
        System.out.println("# memberId: " + memberId);

//        retunr null;
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getMembers() {
        System.out.println("# get Members");

//        retunr null;
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
