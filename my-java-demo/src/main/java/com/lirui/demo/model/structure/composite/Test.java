package com.lirui.demo.model.structure.composite;

/**
 * 组合模式 -- 测试类
 * @author Ryan
 */
public class Test {

    public static void main(String[] args) {
        Organization university = new University("大连大学", "呼啸山庄");
        Organization college1 = new College("信息工程","信息工程");
        Organization college2 = new College("机械工程","机械工程");
        Organization dept11 = new Department("自动化","自动化");
        Organization dept12 = new Department("信科","信科");
        Organization dept21 = new Department("机械自动化","机械自动化");
        Organization dept22 = new Department("AutoCAD","AutoCAD");
        college1.add(dept11);
        college1.add(dept12);
        college2.add(dept21);
        college2.add(dept22);
        university.add(college1);
        university.add(college2);
        university.print();
    }
}
