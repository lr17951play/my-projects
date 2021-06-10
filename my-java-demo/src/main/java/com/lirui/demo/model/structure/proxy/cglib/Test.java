package com.lirui.demo.model.structure.proxy.cglib;

public class Test {

    public static void main(String[] args) {
        Movie movie = new Movie("<速度与激情7>");
        Movie proxy = (Movie) new CglibProxy(movie).getProxyInstance();
        proxy.play();
    }
}
