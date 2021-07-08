package com.lirui.demo.model.action.command;

/**
 * 命令模式，客户端忽略接收方以及接收细节，实现解耦
 * @author Ryan
 */
public class Test {

    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        BeefNoodles bn = new BeefNoodles(3);
        ChickenNoodles cn1 = new ChickenNoodles(3);
        ChickenNoodles cn2 = new ChickenNoodles(2);
        Cake cake = new Cake(5);
        waiter.addOrder(bn);
        waiter.addOrder(cn1);
        waiter.addOrder(cn2);
        waiter.addOrder(cake);
        waiter.cancel(cn1);
        waiter.commit();
    }
}
