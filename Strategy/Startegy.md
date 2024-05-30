## Padrão Strategy

O padrão Strategy é comumente utilizado para reutilização de componentes do seu código, permitindo que um algoritmo varie independentemente dos clientes que o utilizam. Este padrão define uma família de algoritmos, encapsula-os e torna-os intercambiáveis.

### Exemplo: Aplicação de Descontos em Livros

Vamos imaginar que você foi designado para implementar um algoritmo que aplica desconto em livros. Inicialmente, poderíamos fazer assim:

### Implementação Inicial

#### Classe `Book`

```java
public class Book {
    private String title;
    private Double price;
    private Double discount;

    public Book(String title, Double price, Double discount) {
        this.title = title;
        this.price = price;
        this.discount = discount;
    }

    public Double getPriceFinal() {
        if (this.price == 0.0) {
            return price;
        }
        return this.price * (1 - this.discount);
    }
}
```

#### Classe App

```java
public class App {
    public static void main(String[] args) {
        Book bookNoDiscount = new Book("Design Pattern", 50.0, 0.0);
        System.out.println("Book without discount: " + bookNoDiscount.getPriceFinal());

        Book bookWithDiscount = new Book("Design Pattern", 100.0, 0.20);
        System.out.println("Book with discount: " + bookWithDiscount.getPriceFinal());
    }
}
```

**Problema**: Adicionar novos tipos de desconto exigiria modificações constantes na classe `Book`, tornando o código difícil de manter e expandir.

### Aplicando o Padrão Strategy

Vamos refatorar esse código para usar o padrão Strategy, permitindo que diferentes estratégias de desconto sejam aplicadas de forma intercambiável.

#### 1. Interface `DiscountStrategy`

Primeiro, crie uma interface que define a estratégia de desconto:

```java
// Interface que define a estratégia de desconto
public interface DiscountStrategy {
    double applyDiscount(double price);
}
```

#### 2. Implementações da Interface

Agora, vamos criar diferentes estratégias de desconto implementando a interface `DiscountStrategy`.

##### Classe `NoDiscount`

```java
// Estratégia que não aplica nenhum desconto
public class NoDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        // Retorna o preço original sem desconto
        return price;
    }
}
```

##### Classe `SeasonalDiscount`

```java
// Estratégia de desconto sazonal
public class SeasonalDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        // Aplica 10% de desconto sazonal
        return price * 0.9;
    }
}
```

##### Classe `MembershipDiscount`

```java
// Estratégia de desconto para membros
public class MembershipDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        // Aplica 15% de desconto para membros
        return price * 0.85;
    }
}
```

#### 3. Classe `Book`

Modifique a classe `Book` para usar a interface `DiscountStrategy`:

```java
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
```

#### 4. Classe App

Agora, veja como a classe principal (App) fica mais flexível e organizada:

```java
package com.design_pattern.Strategy.pattern;

public class App {
    public static void main(String[] args) {
        // Livro sem desconto
        Book bookNoDiscount = new Book("Design Pattern without discount", 50.0, new NoDiscount());
        System.out.println("Final price with no discount: " + bookNoDiscount.getFinalPrice());

        // Livro com desconto sazonal
        Book bookSeasonalDiscount = new Book("Design Pattern with seasonal discount", 50.0, new SeasonalDiscount());
        System.out.println("Final price with seasonal discount: " + bookSeasonalDiscount.getFinalPrice());

        // Livro com desconto para membros
        Book bookMembershipDiscount = new Book("Design Pattern with membership discount", 50.0, new MembershipDiscount());
        System.out.println("Final price with membership discount: " + bookMembershipDiscount.getFinalPrice());
    }
}
```

### Conclusão

O padrão Strategy melhora a flexibilidade e a escalabilidade do código, permitindo adicionar novas estratégias de desconto sem modificar a lógica central do objeto `Book`. Isso facilita a manutenção e expansão do código, tornando-o mais robusto e adaptável a mudanças. 

Adotar o padrão Strategy não só torna seu código mais organizado e modular, mas também prepara sua aplicação para crescer de forma sustentável, incorporando novas funcionalidades de maneira mais simples e eficiente. Além disso, segue o princípio de aberto/fechado (Open/Closed Principle), que recomenda que classes devem estar abertas para extensão, mas fechadas para modificação.

---
