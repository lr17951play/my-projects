package com.lirui.demo.model.structure.adapt;

/**
 * @author Ryan
 */
public class Adapter extends Adaptee implements Target{

    @Override
    public void newProcess() {
        super.originLogic();
        System.out.println("Do some thing special for new process");
    }
}
