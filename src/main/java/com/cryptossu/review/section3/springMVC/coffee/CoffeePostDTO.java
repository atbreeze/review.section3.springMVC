package com.cryptossu.review.section3.springMVC.coffee;

public class CoffeePostDTO {

    private String engName;
    private String korName;
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
