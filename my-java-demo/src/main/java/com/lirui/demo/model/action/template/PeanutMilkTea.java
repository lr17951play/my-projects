package com.lirui.demo.model.action.template;

/**
 * @author Ryan
 */
public class PeanutMilkTea extends MilkTea{

    PeanutMilkTea (){
        System.out.println("开始制作花生奶茶");
    }
    @Override
    void addCondiment() {
        System.out.println("step 4: 加入花生碎");
    }
}
