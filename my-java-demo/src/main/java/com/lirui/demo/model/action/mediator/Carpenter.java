package com.lirui.demo.model.action.mediator;

import lombok.SneakyThrows;

/**
 * 具体同事类
 * @author Ryan
 */
public class Carpenter extends Worker {

    public Carpenter(ProjectManager pm) {
        super(pm);
    }

    @SneakyThrows
    @Override
    void work() {
        System.out.println("木工开始做柜子了...");
        Thread.sleep(1000L);
        System.out.println("木工干完活了...");
        pm.done(this);
    }
}
