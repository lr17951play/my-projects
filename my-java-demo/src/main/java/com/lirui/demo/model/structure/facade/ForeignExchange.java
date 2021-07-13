package com.lirui.demo.model.structure.facade;

/**
 * @author Ryan
 */
public class ForeignExchange {

    public void bug(double amount) {
        System.out.printf("买入外汇 %f 元", amount);
        System.out.println();
    }

    public void sell(double amount) {
        System.out.printf("卖出外汇 %f 元", amount);
        System.out.println();
    }
}
