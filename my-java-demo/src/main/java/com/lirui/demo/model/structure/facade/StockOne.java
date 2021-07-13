package com.lirui.demo.model.structure.facade;

/**
 * @author Ryan
 */
public class StockOne {

    public void bug(double amount) {
        System.out.printf("买入股票一 %f 元", amount);
        System.out.println();
    }

    public void sell(double amount) {
        System.out.printf("卖出股票一 %f 元", amount);
        System.out.println();
    }
}
