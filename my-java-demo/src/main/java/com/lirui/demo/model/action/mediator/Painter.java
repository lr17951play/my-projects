package com.lirui.demo.model.action.mediator;

import lombok.SneakyThrows;

/**
 * 具体同事类
 * @author Ryan
 */
public class Painter extends Worker {

    public Painter(ProjectManager pm) {
        super(pm);
    }

    @SneakyThrows
    @Override
    void work() {
        System.out.println("油漆工开始刷墙了...");
        Thread.sleep(1000L);
        System.out.println("油漆工干完活了...");
        pm.done(this);
    }
}
