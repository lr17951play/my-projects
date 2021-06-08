package com.lirui.demo.model.creation.singleton;

/**
 * @author Ryan
 */
public class InnerSingleton {

    private static class SingletonHolder {
        private static InnerSingleton INSTANCE = new InnerSingleton();
    }

    public static InnerSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private InnerSingleton () {

    }
}
