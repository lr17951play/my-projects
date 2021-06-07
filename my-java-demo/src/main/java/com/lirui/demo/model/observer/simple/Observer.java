package com.lirui.demo.model.observer.simple;

public abstract class Observer {

    protected String name;

    abstract void update(String message);
}
