package com.lirui.demo.model.action.mediator;

/**
 * 仲裁者模式（中介者模式）
 * @author Ryan
 */
public class Test {

    public static void main(String[] args) {
        ProjectManager pm = new ManagerRyan();
        pm.decorate();
    }
}
