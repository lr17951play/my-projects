package com.lirui.demo.model.creation.prototype;

/**
 * @author Ryan
 */
public class Test {

    public static void main(String[] args) {
        Engine engine = new Engine();
        engine.setBrand("Tesla");
        engine.setType(1);

        Wheel wheel = new Wheel();
        wheel.setBrand("Michelin");
        wheel.setModel(1);
        wheel.setR(19.0);

        Car car = new Car();
        car.setBrand("Tesla");
        car.setModel("Model X");
        car.setEngine(engine);
        car.setWheel(wheel);

        System.out.println("Origin:");
        System.out.println(car.toString());
        System.out.println("HASH ---> engine: " + car.getEngine().hashCode() + ", wheel: " + car.getWheel().hashCode());

        try {
            Car cloned = (Car) car.clone();
            System.out.println("Cloned:");
            System.out.println(cloned.toString());
            System.out.println("HASH ---> engine: " + cloned.getEngine().hashCode() + ", wheel: " + cloned.getWheel().hashCode());
            cloned.setBrand("Audi");
            cloned.getEngine().setBrand("Audi");
            cloned.getWheel().setR(18.0);
            System.out.println("------------------------AFFECTED--------------------------");
            System.out.println("Origin:" + car.toString());
            System.out.println("Target:" + cloned.toString());

            Car deepCloned = car.deepClone();
            System.out.println("DeepCloned:");
            System.out.println(deepCloned.toString());
            System.out.println("HASH ---> engine: " + deepCloned.getEngine().hashCode() + ", wheel: " + deepCloned.getWheel().hashCode());
            deepCloned.setBrand("Benz");
            deepCloned.getEngine().setBrand("Benz");
            deepCloned.getWheel().setR(20.0);
            System.out.println("------------------------UNAFFECTED--------------------------");
            System.out.println("Origin:" + car.toString());
            System.out.println("Target:" + deepCloned.toString());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
