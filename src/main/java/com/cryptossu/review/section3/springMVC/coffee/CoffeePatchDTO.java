package com.cryptossu.review.section3.springMVC.coffee;

public class CoffeePatchDTO {

    private long coffeeId;
    private String engName;
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
