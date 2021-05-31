package com.lirui.demo.model.factory;

public class Test {

    private static AbstractFactory factory;

    public static void main(String[] args) {
        // simple factory
        Phone phone = (Phone) SimpletFactory.create(Phone.class);
        System.out.println(phone.getName());
        Laptop laptop = (Laptop) SimpletFactory.create(Laptop.class);
        System.out.println(laptop.getName());

        // abstract factory
        factory = new ProductFactory();
        Phone phone1 = (Phone) factory.create(Phone.class);
        System.out.println(phone1.getName());
        Laptop laptop1 = (Laptop) factory.create(Laptop.class);
        System.out.println(laptop1.getName());
    }
}
