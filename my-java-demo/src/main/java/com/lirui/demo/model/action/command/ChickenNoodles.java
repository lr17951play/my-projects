package com.lirui.demo.model.action.command;

/**
 * @author Ryan
 */
public class ChickenNoodles implements Meal{

    private int num;

    private NoodlesChef chef;

    public ChickenNoodles(int num){
        this.num = num;
    }

    public void cookedBy(NoodlesChef chef) {
        this.chef = chef;
    }

    @Override
    public void cooking() {
        chef.cookChickenNoodles(num);
    }
}
