package com.design_pattern.Strategy;

import com.design_pattern.Strategy.pattern.Book;
import com.design_pattern.Strategy.pattern.MembershipDiscount;
import com.design_pattern.Strategy.pattern.NoDiscount;
import com.design_pattern.Strategy.pattern.SeasonalDiscount;

public class App {
    public static void main(String[] args) {
        Book bookNoDiscount = new Book("Design Pattern without discount", 50.0, new NoDiscount());
        System.out.println("Final price with no discount: " + bookNoDiscount.getFinalPrice());

        Book bookSeasonalDiscount = new Book("Design Pattern with seasonal discount", 50.0, new SeasonalDiscount());
        System.out.println("Final price with seasonal: " + bookSeasonalDiscount.getFinalPrice());

        Book bookMembershipDiscount = new Book("Design Pattern with membership discount", 50.0, new MembershipDiscount());
        System.out.println("Final price with membership: " + bookMembershipDiscount.getFinalPrice());
    }
}
