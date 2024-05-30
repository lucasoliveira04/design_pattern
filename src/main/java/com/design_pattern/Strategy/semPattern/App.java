package com.design_pattern.Strategy.semPattern;

public class App {
    public static void main(String[] args) {
        Book bookNoDiscount = new Book("Design Pattern", 50.0, 0.0);
        System.out.println("Book without discount: " + bookNoDiscount.getPriceFinal());

        Book bookWithDiscount = new Book("Design Pattern", 100.0, 0.20);
        System.out.println("Book with discount: " + bookWithDiscount.getPriceFinal());
    }
}
