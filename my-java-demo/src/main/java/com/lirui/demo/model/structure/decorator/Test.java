package com.lirui.demo.model.structure.decorator;

public class Test {

    public static void main(String[] args) {
        Drink milkTea = new MilkTea();
        milkTea = new Ice(milkTea);
        milkTea = new Sugar(milkTea);
        System.out.println(milkTea.getName() + milkTea.getDesc() + ", 共花费：" + milkTea.cost());

        Drink fruitJuice = new FruitJuice();
        fruitJuice = new Ice(fruitJuice);
        System.out.println(fruitJuice.getName() + fruitJuice.getDesc() + ", 共花费：" + fruitJuice.cost());
    }
}
