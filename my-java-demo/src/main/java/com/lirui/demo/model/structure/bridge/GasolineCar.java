package com.lirui.demo.model.structure.bridge;

/**
 * RefinedAbstraction
 * @author Ryan
 */
public class GasolineCar extends Car{

    public GasolineCar(Brand brand) {
        super(brand);
        System.out.println("汽油车来了");
    }

    @Override
    void start() {
        brand.start();
        System.out.println("汽油车起步，发动机打火");
    }

    @Override
    void run() {
        brand.run();
        System.out.println("汽油车平稳运行，发动机油耗低");
    }

    @Override
    void stop() {
        brand.stop();
        System.out.println("汽油车停止，油耗高");
    }
}
