package com.lirui.demo.model.action.strategy;

/**
 * 具体策略类
 * @author Ryan
 */
public class NormalCharge implements Discount{

    @Override
    public void discount(double price) {
        System.out.println("未达到优惠条件，价格: " + price);
    }
}
