package com.lirui.demo.model.action.strategy;

import java.util.HashMap;

/**
 * 策略上下文
 * @author Ryan
 */
public class StrategyContext {

    private static HashMap<Integer, Discount> strategyMap = new HashMap<>();

    /** 维护策略集合（Map, Enum...）*/
    static {
        strategyMap.put(1, new NormalCharge());
        strategyMap.put(2, new CashBack(0.1));
    }

    /** 获取策略 */
    public Discount getStrategy(int amount){
        if (amount < 1) {
            throw new IllegalArgumentException("Amount Can Not Less Than 1");
        }
        Discount strategy = strategyMap.get(amount);
        if (strategy == null) {
            strategy = new PriceDiscount(8);
        }
        return strategy;
    }
}
