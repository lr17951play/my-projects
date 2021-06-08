package com.lirui.demo.model.builder;

/**
 * @author Ryan
 */
public class CommonBuilder extends CarBuilder{

    @Override
    public CarBuilder buildBrand(String brand) {
        this.car.setBrand(brand);
        return this;
    }

    @Override
    public CarBuilder buildModel(String model) {
        this.car.setModel(model);
        return this;
    }

    @Override
    public CarBuilder buildEngine(String engine) {
        this.car.setEngine(engine);
        return this;
    }

    @Override
    public CarBuilder buildFrame(String frame) {
        this.car.setFrame(frame);
        return this;
    }

    @Override
    public CarBuilder buildWheel(String wheel) {
        this.car.setWheel(wheel);
        return this;
    }
}
