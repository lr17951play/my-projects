package com.lirui.demo.model.structure.facade;

/**
 * 外观模式
 * @author Ryan
 */
public class Test {

    public static void main(String[] args) {
        FundManager fundManager = new FundManager();
        System.out.println("============ 客户投资基金 ============");
        fundManager.bugFund(10000);
        System.out.println("============ 客户卖出基金 ============");
        fundManager.sellFund(5000);
    }
}
