package com.design_pattern.Strategy.pattern;

public class SeasonalDiscount implements DiscountStrategy{

    @Override
    public double applyDiscount(double price) {
        return price * 0.9;
    }
}
