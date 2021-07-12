package com.lirui.demo.model.action.strategy;

/**
 * @author Ryan
 */
public class Test {

    private static StrategyContext context = new StrategyContext();

    public static void main(String[] args) {
        Discount discount = context.getStrategy(1);
        discount.discount(3000);
    }
}
