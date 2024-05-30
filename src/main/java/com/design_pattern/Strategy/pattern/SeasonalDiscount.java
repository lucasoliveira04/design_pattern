package com.design_pattern.Strategy.pattern;

// Estratégia de desconto sazonal
public class SeasonalDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        // Aplica 10% de desconto sazonal
        return price * 0.9;
    }
}