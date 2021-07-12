package com.lirui.demo.model.action.strategy;

import lombok.AllArgsConstructor;

/**
 * 具体策略类
 * @author Ryan
 */
@AllArgsConstructor
public class PriceDiscount implements Discount{

    private double rate;

    @Override
    public void discount(double price) {
        System.out.println("全部 " + rate + "折，总共: " + price * rate / 10);
    }
}
