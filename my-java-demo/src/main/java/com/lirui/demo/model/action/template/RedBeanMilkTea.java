package com.lirui.demo.model.action.template;

/**
 * @author Ryan
 */
public class RedBeanMilkTea extends MilkTea{

    private String diy;

    RedBeanMilkTea (String diy){
        System.out.println("开始制作红豆奶茶");
        this.diy = diy;
    }

    @Override
    void addCondiment() {
        System.out.println("step 4: 加入红豆");
    }

    @Override
    protected void diy() {
        super.diy();
        System.out.println(diy);
    }
}
