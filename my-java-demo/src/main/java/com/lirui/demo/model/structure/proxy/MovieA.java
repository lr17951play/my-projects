package com.lirui.demo.model.structure.proxy;

public class MovieA extends Movie {

    public MovieA(){
        this.name = "<速度与激情9>";
    }

    @Override
    public void play() {
        System.out.println("您正在收看" + this.name);
    }
}
