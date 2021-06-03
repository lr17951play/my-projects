package com.lirui.demo.reference.soft;

public class Test {

    public static void main(String[] args) {
        PersonCache instance = PersonCache.getInstance();
        long time = System.currentTimeMillis();
        System.out.println("create new people");
        for (int i = 0; i < 5; i++) {
            instance.getPerson(i);
        }
        System.out.println("create new people done within(s): " + (System.currentTimeMillis() - time) / 1000);
        time = System.currentTimeMillis();
        System.out.println("get people from cache");
        for (int i = 0; i < 5; i++) {
            instance.getPerson(i);
        }
        System.out.println("get people from cache done within(s): " + (System.currentTimeMillis() - time) / 1000);
    }
}
