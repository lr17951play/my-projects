package com.lirui.demo.model.structure.adapt;

public class Client {

    public static void main(String[] args) {
        Target target = new Adapter();
        target.newProcess();
    }
}
