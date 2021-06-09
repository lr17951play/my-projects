package com.lirui.demo.model.structure.decorator;

public class Sugar extends Condiment{

    public Sugar(Drink drink) {
        super(drink);
    }

    @Override
    public double cost() {
        return drink.cost() + 0.5;
    }

    @Override
    public String getDesc() {
        return drink.getDesc() + " + 糖";
    }
}
