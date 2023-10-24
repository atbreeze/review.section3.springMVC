package com.cryptossu.review.section3.springMVC.member.exception;

import lombok.Getter;

public enum ExceptionCode {
    MEMBER_NOT_FOUND(404, "Member Not Found"),
    MEMBER_NOT_ALLOWED(406, "Member Not Allowed"),
    INTERNAL_SEVER_ERROR(500, "Internal Server Error"),
    MEMBER_EXISTS(409,"Member Already Exists"),
    COFFEE_NOT_FOUND(404, "Coffee Not Found"),
    COFFEE_CODE_EXISTS(409,"Coffee_Code Already Exists"),
    CANNOT_CHANGE_ORDER(403,"Can Not Change Order"),
    ORDER_NOT_FOUND(404,"Order Not Found"),
    NOT_IMPLEMENTATION(501,"Not Implementation")
    ;

    @Getter
    private int status;

    @Getter
    private String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
