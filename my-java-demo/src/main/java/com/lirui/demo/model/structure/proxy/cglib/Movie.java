package com.lirui.demo.model.structure.proxy.cglib;

import lombok.NoArgsConstructor;

/**
 * 需要空参构造器
 * @author Ryan
 */
@NoArgsConstructor
public class Movie {

    private String name;

    public Movie (String name) {
        this.name = name;
    }

    public void play() {
        System.out.println("您正在收看: " + this.name);
    }
}
