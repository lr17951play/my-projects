package com.lirui.demo.model.structure.facade;

/**
 * @author Ryan
 */
public class StockTwo {

    public void bug(double amount) {
        System.out.printf("买入股票二 %f 元", amount);
        System.out.println();
    }

    public void sell(double amount) {
        System.out.printf("卖出股票二 %f 元", amount);
        System.out.println();
    }
}
