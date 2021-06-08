package com.lirui.demo.model.creation.builder;

public class BuildDirector {

    private CarBuilder builder;

    public BuildDirector(CarBuilder builder) {
        this.builder = builder;
    }

    public Car autoBuild() {
       return builder.buildBrand("Tesla")
                .buildModel("ModelX")
                .buildEngine("Engine X")
                .buildFrame("Frame X")
                .buildWheel("20R Wheel")
                .build();
    }
}
