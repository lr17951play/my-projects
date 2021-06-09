package com.lirui.demo.model.structure.proxy;

public class MovieB extends Movie {

    public MovieB() {
        this.name = "<后天>";
    }

    @Override
    public void play() {
        System.out.println("正片马上开始：" + this.name);
    }
}
