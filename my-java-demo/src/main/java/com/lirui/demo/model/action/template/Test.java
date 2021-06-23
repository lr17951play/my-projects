package com.lirui.demo.model.action.template;

/**
 * @author Ryan
 */
public class Test {

    public static void main(String[] args) {
        MilkTea milkTea1 = new RedBeanMilkTea("加入多多的冰");
        milkTea1.make();

        PeanutMilkTea milkTea2 = new PeanutMilkTea();
        milkTea2.make();
    }
}
