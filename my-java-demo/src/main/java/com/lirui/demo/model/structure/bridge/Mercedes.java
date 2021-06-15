package com.lirui.demo.model.structure.bridge;

/**
 * ConcreateImplementor
 * @author Ryan
 */
public class Mercedes implements Brand{
    @Override
    public void start() {
        System.out.println("梅赛德斯起步，氛围灯搞起");
    }

    @Override
    public void run() {
        System.out.println("梅赛德斯运行，空调给力");
    }

    @Override
    public void stop() {
        System.out.println("梅赛德斯刹车灵敏");
    }
}
