package com.lirui.demo.model.creation.singleton;

/**
 * @author Ryan
 */
public class Singleton {

    /** 构造器私有化 */
    private Singleton() {}

    private static final Singleton single = new Singleton();
    public static Singleton getInstance() {
        return single;
    }
}
