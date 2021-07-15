package com.lirui.demo.model.action.mediator;

import lombok.AllArgsConstructor;

/**
 * 抽象同事类
 * @author Ryan
 */
@AllArgsConstructor
public abstract class Worker {

    protected ProjectManager pm;

    abstract void work();
}
