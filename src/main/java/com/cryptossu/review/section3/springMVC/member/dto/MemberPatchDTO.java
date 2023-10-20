package com.cryptossu.review.section3.springMVC.member.dto;

import com.cryptossu.review.section3.springMVC.NotSpace;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class MemberPatchDTO {

    private long memberId;
//    @Pattern(regexp = "^\\S+(\\s?\\S+)*$", message = "회원이름은 공백이 아니어야 합니다.")
    @NotBlank(message = "회원 이름은 공백이 아니어야 합니다.")
    private String name;
    @Pattern(regexp = "^010-\\d{3,4}-\\d{4}$"
            , message = "휴대폰 번호는 010으로 시작하는 11자리 숫자와 '-'로 구성되어야 합니다.")
    private String phone;

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public long getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }
}
