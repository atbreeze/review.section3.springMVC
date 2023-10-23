package com.cryptossu.review.section3.springMVC.hello_world;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class MessagePostDto {
    @NotBlank
    private String message;
}
