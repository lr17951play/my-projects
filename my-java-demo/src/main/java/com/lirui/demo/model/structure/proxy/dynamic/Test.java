package com.lirui.demo.model.structure.proxy.dynamic;

import com.lirui.demo.model.structure.proxy.Imovie;
import com.lirui.demo.model.structure.proxy.MovieA;

public class Test {

    public static void main(String[] args) {
        Imovie movie = new MovieA();
        Imovie movieProxy = (Imovie) new DynamicProxy(movie).getProxyInstance();
        movieProxy.play();
    }
}
