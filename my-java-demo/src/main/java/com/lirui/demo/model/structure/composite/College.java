package com.lirui.demo.model.structure.composite;

import java.util.ArrayList;

/**
 * 组合模式 -- 容器构件
 * @author Ryan
 */
public class College extends Organization{

    private ArrayList<Organization> departments = new ArrayList<>();

    public College(String name, String desc){
        super(name, desc);
    }

    @Override
    public void add(Organization org) {
        departments.add(org);
    }

    @Override
    public void remove(Organization org) {
        departments.remove(org);
    }

    @Override
    protected void print() {
        System.out.println("|---College: " + this.getName() + " " + this.getDesc());
        departments.forEach(x -> {
            x.print();
        });
    }
}
