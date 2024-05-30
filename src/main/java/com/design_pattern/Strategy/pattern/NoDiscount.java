package com.design_pattern.Strategy.pattern;

public class NoDiscount implements DiscountStrategy{
    @Override
    public double applyDiscount(double price) {
        return price;
    }
}
