package com.lirui.demo.model.structure.composite;

/**
 * 组合模式 -- 叶子节点
 * @author Ryan
 */
public class Department extends Organization {

    public Department(String name, String desc) {
        super(name, desc);
    }

    @Override
    protected void print() {
        System.out.println("   |---Department: " + this.getName() + " " + this.getDesc());
    }
}
