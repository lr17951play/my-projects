package com.lirui.demo.model.action.mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * 具体仲裁者（负责同事的任务安排和同事间工作的协调）
 * @author Ryan
 */
public class ManagerRyan implements ProjectManager {

    private Map<String, Worker> workers = new HashMap<>();

    private final String Mason = "张三";

    private final String Carpenter = "李四";

    private final String Painter = "王五";

    private final String Plumber = "李狗蛋";

    public ManagerRyan() {
        workers.put(Plumber, new Plumber(this));
        workers.put(Mason, new Mason(this));
        workers.put(Carpenter, new Carpenter(this));
        workers.put(Painter, new Painter(this));
    }

    @Override
    public void decorate() {
        System.out.println("来活了，兄弟们开始干！");
        workers.get(Plumber).work();
    }

    /** 解耦同事间的通信，由仲裁者完成沟通工作 */
    @Override
    public void done(Worker worker) {
        if (worker instanceof Plumber) {
            workers.get(Mason).work();
        } else if (worker instanceof Mason) {
            workers.get(Carpenter).work();
        } else if (worker instanceof Carpenter) {
            workers.get(Painter).work();
        } else {
            System.out.println("活干完了，业主爸爸交钱吧");
        }
    }
}
