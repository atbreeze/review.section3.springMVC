package com.cryptossu.review.section3.springMVC.coffee.dto;

import lombok.Getter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
public class CoffeePostDTO {
    @NotBlank(message = "Type in your Name")
    @Pattern(regexp = "^([a-zA-Z]+)(\\s?[a-zA-Z])*$")
    //영문만 허용
    // 워드 사이에 한칸의 공백만 포함
    private String engName;
    @NotBlank(message = "상품명을 입력하세요")
    private String korName;

    @Range(min = 1000, max = 50000)
    private int price;

    @NotBlank
    @Pattern(regexp = "^([A=Za-z]){3}$", message = "커피 코드는 3자리 영문이어야 합니다.")
    private String coffeeCode;
}
