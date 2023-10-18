//package com.cryptossu.review.section3.springMVC;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

//public class RestTemplateExample {
//    public static void main(String[] args) {
//
//        // (1) 객체 생성
//        RestTemplate restTemplate =
//                new RestTemplate(new HttpComponentsClientHttpRequestFactory());
//
//        // (2) URI 생성
//        UriComponents uriComponents =
//                UriComponentsBuilder
//                        .newInstance()
//                        .scheme("http")
//                        .host("worldtimeapi.org")
////                        .port(80)
//                        .path("/api/timezone/{continents}/{city}")
//                        .encode()
//                        .build();
//        URI uri = uriComponents.expand("Asia", "Seoul").toUri();
//
//        // (3) Request 전송
////        String result = restTemplate.getForObject(uri, String.class);
////
////        System.out.println(result);
//
////        // (3) Request 전송. WorldTime 클래스로 응답 데이터를 전달받는다.
////        WorldTime worldTime = restTemplate.getForObject(uri, WorldTime.class);
////
////        System.out.println("# datatime: " + worldTime.getDatetime());
////        System.out.println("# timezone: " + worldTime.getTimezone());
////        System.out.println("# day_of_week: " + worldTime.getDay_of_week());
//
//        // (3) Request 전송. ResponseEntity로 헤더와 바디 정보를 모두 전달받을 수 있다.
////        ResponseEntity<WorldTime> response =
////                restTemplate.getForEntity(uri, WorldTime.class);
////
////        System.out.println("# datatime: " + response.getBody().getDatetime());
////        System.out.println("# timezone: " + response.getBody().getTimezone()());
////        System.out.println("# day_of_week: " + response.getBody().getDay_of_week());
////        System.out.println("# HTTP Status Code: " + response.getStatusCode());
////        System.out.println("# HTTP Status Value: " + response.getStatusCodeValue());
////        System.out.println("# Content Type: " + response.getHeaders().getContentType());
////        System.out.println(response.getHeaders().entrySet());
//
//        // (3) Request 전송. exchange()를 사용한 일반화 된 방식
//        ResponseEntity<WorldTime> response =
//                restTemplate.exchange(uri,
//                        HttpMethod.GET,
//                        null,
//                        WorldTime.class);
//
//        System.out.println("# datatime: " + response.getBody().getDatetime());
//        System.out.println("# timezone: " + response.getBody().getTimezone());
//        System.out.println("# day_of_week: " + response.getBody().getDay_of_week());
//        System.out.println("# HTTP Status Code: " + response.getStatusCode());
//        System.out.println("# HTTP Status Value: " + response.getStatusCodeValue());
//
//
//    }
//}
