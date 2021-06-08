package com.lirui.demo.model.action.observer.simple;

public class SimpleObserver extends Observer{

    @Override
    public void update(String message) {
        System.out.println(super.name + " Get message: " + message);
    }

    public SimpleObserver (String name) {
        super.name = name;
    }
}
