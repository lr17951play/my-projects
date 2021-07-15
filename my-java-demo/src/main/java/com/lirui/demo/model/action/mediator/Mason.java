package com.lirui.demo.model.action.mediator;

import lombok.SneakyThrows;

/**
 * 具体同事类
 * @author Ryan
 */
public class Mason extends Worker{

    public Mason(ProjectManager pm) {
        super(pm);
    }

    @SneakyThrows
    @Override
    void work() {
        System.out.println("泥瓦工开始贴瓷砖了...");
        Thread.sleep(1000L);
        System.out.println("泥瓦工干完活了...");
        pm.done(this);
    }
}
