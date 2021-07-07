package com.lirui.demo.model.structure.composite;


import java.util.ArrayList;
/**
 * 组合模式 -- 容器构件
 * @author Ryan
 */
public class University extends Organization{

    private ArrayList<Organization> colleges = new ArrayList();

    public University(String name, String desc) {
        super(name, desc);
    }

    @Override
    public void add(Organization org) {
        colleges.add(org);
    }

    @Override
    public void remove(Organization org) {
        colleges.remove(org);
    }

    @Override
    protected void print() {
        System.out.println("University: " + this.getName() + " " + this.getDesc());
        colleges.forEach(x -> {
            x.print();
        });
    }
}
