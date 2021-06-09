package com.lirui.demo.model.structure.decorator;

/**
 * @author Ryan
 */
public class Ice extends Condiment{

    public Ice (Drink drink) {
        super(drink);
    }

    @Override
    public double cost() {
        return drink.cost() + 0.4;
    }

    @Override
    public String getDesc() {
        return drink.getDesc() + " + 冰";
    }
}
