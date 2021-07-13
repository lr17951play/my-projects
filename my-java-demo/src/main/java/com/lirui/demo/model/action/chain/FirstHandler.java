package com.lirui.demo.model.action.chain;

/**
 * @author Ryan
 */
public class FirstHandler extends Handler{


    @Override
    protected boolean resolve(int target) {
        System.out.println("一号处理器: 处理 10 以下的数字...");
        return target < 10;
    }
}
