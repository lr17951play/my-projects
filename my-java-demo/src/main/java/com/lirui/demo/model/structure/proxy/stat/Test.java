package com.lirui.demo.model.structure.proxy.stat;

import com.lirui.demo.model.structure.proxy.MovieA;
import com.lirui.demo.model.structure.proxy.MovieB;

public class Test {

    public static void main(String[] args) {
        MovieProxy proxy = new MovieProxy(new MovieA());
        proxy.play();
        proxy = new MovieProxy(new MovieB());
        proxy.play();
    }
}
