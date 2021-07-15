package com.lirui.demo.model.action.mediator;

/**
 * 抽象仲裁者（接口）
 * @author Ryan
 */
public interface ProjectManager {

    void decorate();

    void done(Worker worker);
}
