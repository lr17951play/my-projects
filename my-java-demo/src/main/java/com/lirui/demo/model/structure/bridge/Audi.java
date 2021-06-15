package com.lirui.demo.model.structure.bridge;

/**
 * ConcreateImplementor
 * @author Ryan
 */
public class Audi implements Brand{
    @Override
    public void start() {
        System.out.println("奥迪起步，车灯走起");
    }

    @Override
    public void run() {
        System.out.println("奥迪运行，坐着舒服");
    }

    @Override
    public void stop() {
        System.out.println("奥迪刹车绵柔");
    }
}
