package com.lirui.demo.model.structure.facade;

/**
 * Facade 门面角色，对外提供统一的接口，将客户端请求代理到多个子系统中，简化客户端请求，实现解耦
 * @author Ryan
 */
public class FundManager {

    private StockOne stockOne = new StockOne();

    private StockTwo stockTwo = new StockTwo();

    private Bond bond = new Bond();

    private ForeignExchange foreignExchange = new ForeignExchange();

    public void bugFund(double amount){
        System.out.printf("----------------> 基金经理操作投资：共计 %f 元 \n", amount);
        stockOne.bug(amount * 0.2);
        stockTwo.bug(amount * 0.2);
        bond.bug(amount * 0.3);
        foreignExchange.bug(amount * 0.3);
    }

    public void sellFund(double amount){
        System.out.printf("----------------> 基金经理操作赎回：共计 %f 元 \n", amount);
        stockOne.sell(amount * 0.2);
        stockTwo.sell(amount * 0.2);
        bond.sell(amount * 0.3);
        foreignExchange.sell(amount * 0.3);
    }
}
