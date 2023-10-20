package com.cryptossu.review.section3.springMVC.member.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.SpringApplication;
@Getter
//게터 자동생성
@Setter
//세터 자동생성
@NoArgsConstructor
//public Member() {
//        }
@AllArgsConstructor
//public Member(long memberId, String email, String name, String phone) {
//        this.memberId = memberId;
//        this.email = email;
//        this.name = name;
//        this.phone = phone;
//        }
public class Member {
    private long memberId;
    private String email;
    private String name;
    private String phone;
}
