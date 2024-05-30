package com.design_pattern.Strategy.pattern;

// Estratégia de desconto para membros
public class MembershipDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        // Aplica 15% de desconto para membros
        return price * 0.85;
    }
}