package com.design_pattern.Strategy.pattern;

// Classe que representa um Livro
public class Book {
    private String title; // Título do livro
    private double price; // Preço original do livro
    private DiscountStrategy discountStrategy; // Estratégia de desconto a ser aplicada

    // Construtor da classe Book
    public Book(String title, double price, DiscountStrategy discountStrategy) {
        this.title = title; // Inicializa o título do livro
        this.price = price; // Inicializa o preço do livro
        this.discountStrategy = discountStrategy; // Inicializa a estratégia de desconto
    }

    // Método para calcular o preço final do livro aplicando a estratégia de desconto
    public double getFinalPrice() {
        return discountStrategy.applyDiscount(price); // Aplica o desconto e retorna o preço final
    }
}
