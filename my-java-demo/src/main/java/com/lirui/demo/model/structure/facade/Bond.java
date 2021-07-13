package com.lirui.demo.model.structure.facade;

/**
 * @author Ryan
 */
public class Bond {

    public void bug(double amount) {
        System.out.printf("买入债券 %f 元", amount);
        System.out.println();
    }

    public void sell(double amount) {
        System.out.printf("卖出债券 %f 元", amount);
        System.out.println();
    }
}
