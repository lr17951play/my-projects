package com.lirui.demo.model.structure.decorator;

/**
 * @author Ryan
 */
public abstract class Condiment extends Drink{

    protected Drink drink;

    public Condiment(Drink drink) {
        this.drink = drink;
        this.name = drink.name;
    }

    public abstract String getDesc();
}
