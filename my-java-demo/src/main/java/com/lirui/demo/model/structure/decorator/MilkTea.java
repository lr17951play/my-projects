package com.lirui.demo.model.structure.decorator;

/**
 * @author Ryan
 */
public class MilkTea extends Drink{

    public MilkTea (){
        this.setName("Milk Drink");
        this.setDesc(" ( Good Tea with Fresh Milk) ");
    }

    @Override
    public double cost() {
        return 15;
    }
}
