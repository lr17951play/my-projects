package com.lirui.demo.model.factory;

public abstract class AbstractFactory<T> {

    public abstract T create(Class clazz);
}
