package com.lirui.demo.model.action.mediator;

import lombok.SneakyThrows;

/**
 * 具体同事类
 * @author Ryan
 */
public class Plumber extends Worker {

    public Plumber(ProjectManager pm) {
        super(pm);
    }

    @SneakyThrows
    @Override
    void work() {
        System.out.println("水电工开始开槽排线了...");
        Thread.sleep(1000L);
        System.out.println("水电工干完活了...");
        pm.done(this);
    }
}
