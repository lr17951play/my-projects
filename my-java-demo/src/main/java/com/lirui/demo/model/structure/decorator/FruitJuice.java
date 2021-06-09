package com.lirui.demo.model.structure.decorator;

/**
 * @author Ryan
 */
public class FruitJuice extends Drink{

    public FruitJuice() {
        this.name = "Fruit Juice";
        this.desc = " ( Fresh Fruit Juice ) ";
    }

    @Override
    public double cost() {
        return 20;
    }
}
