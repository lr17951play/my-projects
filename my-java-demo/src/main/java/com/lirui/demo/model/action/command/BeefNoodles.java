package com.lirui.demo.model.action.command;

/**
 * @author Ryan
 */
public class BeefNoodles implements Meal{

    private int num;

    private NoodlesChef chef;

    public BeefNoodles(int num){
        this.num = num;
    }

    public void cookedBy(NoodlesChef chef) {
        this.chef = chef;
    }

    @Override
    public void cooking() {
        chef.cookBeefNoodles(num);
    }
}
