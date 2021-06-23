package com.lirui.demo.model.action.template;


/**
 * 定制奶茶制作流程模板
 * 抽象方法 #addCondiment 根据不同需求加入不同佐料
 * 钩子方法 #diy 默认为空，可根据需要自行处理
 * @author Ryan
 */
public abstract class MilkTea {

    public void make(){
        // step 1
        prepare();
        // step 2
        addMilkPowder();
        // step 3
        addTea();
        // step 4
        addCondiment();
        // hooks
        diy();
        // step 5
        process();
        // step 6
        finish();
    }

    private void prepare(){
        System.out.println("step 1: 准备杯子和吸管");
    }

    private void addMilkPowder(){
        System.out.println("step 2: 加入奶粉");
    }

    private void addTea() {
        System.out.println("step 3: 加入茶水");
    }

    abstract void addCondiment();

    protected void diy(){

    }

    private void process(){
        System.out.println("step 5: 开始制作");
    }

    private void finish(){
        System.out.println("step 6: 制作完成");
    }
}
