package com.lirui.demo.model.builder;

/**
 * @author Ryan
 */
public abstract class CarBuilder {

    protected Car car = new Car();

    public abstract CarBuilder buildBrand(String brand);

    public abstract CarBuilder buildModel(String model);

    public abstract CarBuilder buildEngine(String engine);

    public abstract CarBuilder buildFrame(String frame);

    public abstract CarBuilder buildWheel(String wheel);

    public Car build() {
        System.out.println(car.toString());
        return car;
    };
}
