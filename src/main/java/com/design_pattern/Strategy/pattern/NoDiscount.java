package com.design_pattern.Strategy.pattern;

// Estratégia que não aplica nenhum desconto
public class NoDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        // Retorna o preço original sem desconto
        return price;
    }
}
