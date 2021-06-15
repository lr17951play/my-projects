package com.lirui.demo.model.structure.bridge;

/**
 * Abstraction
 * @author Ryan
 */
public abstract class Car {

    protected Brand brand;

    public Car(Brand brand){
        this.brand = brand;
    }

    abstract void start();

    abstract void run();

    abstract void stop();
}
