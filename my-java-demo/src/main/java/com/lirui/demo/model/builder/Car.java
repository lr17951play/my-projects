package com.lirui.demo.model.builder;

import lombok.Data;

/**
 * @author Ryan
 */
@Data
public class Car {

    private String brand;

    private String model;

    private String engine;

    private String frame;

    private String wheel;

    @Override
    public String toString() {
        return "Brand: " + brand + ", Model: " + model + ", Engine: " + engine +
                ", Frame: " + frame + ", Wheel: " + wheel;
    }
}
