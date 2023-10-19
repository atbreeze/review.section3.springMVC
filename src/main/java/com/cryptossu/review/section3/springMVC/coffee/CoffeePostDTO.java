package com.cryptossu.review.section3.springMVC.coffee;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CoffeePostDTO {
    @NotBlank(message = "Type in your Name")
    @Pattern(regexp = "^([a-zA-Z]+)(\\s?[a-zA-Z])*$")
    //영문만 허용
    // 워드 사이에 한칸의 공백만 포함
    private String engName;
    @NotBlank(message = "상품명을 입력하세요")
    private String korName;
    @Min(1000)
    @Max(50000)
    private int price;

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setKorName(String korName) {
        this.korName = korName;
    }

    public String getEngName() {
        return engName;
    }

    public int getPrice() {
        return price;
    }

    public String getKorName() {
        return korName;
    }
}
