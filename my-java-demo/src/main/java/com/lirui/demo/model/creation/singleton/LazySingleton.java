package com.lirui.demo.model.creation.singleton;

/**
 * @author Ryan
 */
public class LazySingleton {

    private volatile static LazySingleton singleton;

    public static LazySingleton getSingleton() {
        if (singleton == null) {
            synchronized (LazySingleton.class) {
                if (singleton == null) {
                    singleton = new LazySingleton();
                }
            }
        }
        return singleton;
    }

    private LazySingleton () {

    }
}
