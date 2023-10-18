package com.cryptossu.review.section3.springMVC.member;

public class MemberPatchDTO {

    private long memberId;
    private String name;
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
