package com.lirui.demo.model.action.chain;

/**
 * @author Ryan
 */
public class ThirdHandler extends Handler{

    @Override
    protected boolean resolve(int target) {
        System.out.println("三号处理器: 处理 1000 以下的数字...");
        return target < 1000;
    }
}
