package com.lirui.demo.model.action.chain;

/**
 * @author Ryan
 */
public class SecondHandler extends Handler{

    @Override
    protected boolean resolve(int target) {
        System.out.println("二号处理器: 处理 100 以下的数字...");
        return target < 100 ;
    }
}
