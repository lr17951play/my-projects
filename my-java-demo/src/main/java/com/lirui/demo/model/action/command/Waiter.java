package com.lirui.demo.model.action.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ryan
 */
public class Waiter {

    private NoodlesChef noodlesChef = new NoodlesChef();

    private CakeChef cakeChef = new CakeChef();

    private List<Meal> meals = new ArrayList<>();

    /** 此处可结合策略模式使用，减少大量 if-else */
    public void addOrder(Meal meal) {
        if (meal instanceof BeefNoodles) {
            ((BeefNoodles) meal).cookedBy(noodlesChef);
        } else if (meal instanceof ChickenNoodles){
            ((ChickenNoodles) meal).cookedBy(noodlesChef);
        }else if (meal instanceof Cake) {
            ((Cake) meal).cookedBy(cakeChef);
        }
        meals.add(meal);
    }

    public void cancel(Meal meal){
        meals.remove(meal);
    }

    public void commit() {
        meals.forEach(m -> m.cooking());
    }
}
