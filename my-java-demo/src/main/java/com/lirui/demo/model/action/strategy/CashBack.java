package com.lirui.demo.model.action.strategy;

import lombok.AllArgsConstructor;

/**
 * 具体策略类
 * @author Ryan
 */
@AllArgsConstructor
public class CashBack implements Discount{

    private double rate;

    @Override
    public void discount(double price) {
        System.out.println("返利:" + price * rate);
    }
}
