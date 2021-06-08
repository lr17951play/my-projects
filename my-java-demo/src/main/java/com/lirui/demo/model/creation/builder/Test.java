package com.lirui.demo.model.creation.builder;

public class Test {

    public static void main(String[] args) {
        /** auto */
        BuildDirector director = new BuildDirector(new CommonBuilder());
        Car car1 = director.autoBuild();

        /** manually */
        CarBuilder builder = new CommonBuilder();
        Car car2 = builder.buildBrand("Tesla")
                .buildModel("Model 3")
                .buildEngine("Engine 3")
                .buildFrame("Frame 3")
                .buildWheel("18R Whell")
                .build();
    }
}
