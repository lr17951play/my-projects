package com.lirui.demo.model.structure.bridge;

/**
 * @author Ryan
 */
public class Test {

    public static void main(String[] args) {
        Car carA = new ElectricalCar(new Mercedes());
        carA.start();
        carA.run();
        carA.stop();
        System.out.println("-----------------------------------------");
        Car carB = new GasolineCar(new Audi());
        carB.start();
        carB.run();
        carB.stop();
        System.out.println("-----------------------------------------");
        Car carC = new ElectricalCar(new Audi());
        carC.start();
        carC.run();
        carC.stop();
    }
}
