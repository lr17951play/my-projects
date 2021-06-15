package com.lirui.demo.model.structure.bridge;

/**
 * RefinedAbstraction
 * @author Ryan
 */
public class ElectricalCar extends Car{

    public ElectricalCar(Brand brand) {
        super(brand);
        System.out.println("电车来了");
    }

    @Override
    void start() {
        brand.start();
        System.out.println("电车起步，快");
    }

    @Override
    void run() {
        brand.run();
        System.out.println("电车稳定运行，耗电量低");
    }

    @Override
    void stop() {
        brand.stop();
        System.out.println("电车停止，转矩大耗电高");
    }
}
