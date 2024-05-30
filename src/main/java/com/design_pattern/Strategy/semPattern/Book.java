package com.design_pattern.Strategy.semPattern;

public class Book {
    private String title;
    private Double price;
    private Double discount;

    public Book(String title, Double price, Double discount) {
        this.title = title;
        this.price = price;
        this.discount = discount;
    }

    public Double getPriceFinal(){
        if (this.price == 0.0){
            return price;
        }
        return this.price * (1 - this.discount);
    }
}
