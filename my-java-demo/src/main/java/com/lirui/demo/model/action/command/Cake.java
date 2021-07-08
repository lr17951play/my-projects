package com.lirui.demo.model.action.command;

/**
 * @author Ryan
 */
public class Cake implements Meal{

    private int num;

    private CakeChef chef;

    public Cake(int num){
        this.num = num;
    }

    public void cookedBy(CakeChef chef) {
        this.chef = chef;
    }

    @Override
    public void cooking() {
        chef.cookCake(num);
    }
}
