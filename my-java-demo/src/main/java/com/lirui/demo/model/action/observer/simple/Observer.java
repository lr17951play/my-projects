package com.lirui.demo.model.action.observer.simple;

public abstract class Observer {

    protected String name;

    abstract void update(String message);
}
