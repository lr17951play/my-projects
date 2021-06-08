package com.lirui.demo.model.creation.factory;

public abstract class AbstractFactory<T> {

    public abstract T create(Class clazz);
}
