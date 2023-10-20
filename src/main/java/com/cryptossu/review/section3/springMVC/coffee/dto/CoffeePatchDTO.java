package com.cryptossu.review.section3.springMVC.coffee.dto;

import com.cryptossu.review.section3.springMVC.NotSpace;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class CoffeePatchDTO {

    private long coffeeId;
    @NotBlank(message = "Type in your Name")
//    @Pattern(regexp = "^([a-zA-Z]\\s?)+\\S$")
    private String engName;
    @NotBlank(message = "상품명을 입력하세요")
    private String korName;
    private int price;

    public void setCoffeeId(long coffeeId) {
        this.coffeeId = coffeeId;
    }

    public void setEngName(String engName) {
        this.engName = engName;
    }

    public void setKorName(String korName) {
        this.korName = korName;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getCoffeeId() {
        return coffeeId;
    }

    public String getEngName() {
        return engName;
    }

    public String getKorName() {
        return korName;
    }

    public int getPrice() {
        return price;
    }
}
