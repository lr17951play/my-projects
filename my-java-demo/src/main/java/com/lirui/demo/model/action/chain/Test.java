package com.lirui.demo.model.action.chain;

/**
 * 责任链模式
 * @author Ryan
 */
public class Test {

    public static void main(String[] args) {
        Handler handler = new FirstHandler();
        handler.next(new SecondHandler()).next(new ThirdHandler());
        int[] testGroup = new int[]{-9, 0, 9, 99, 999, 9999};
        for (int num : testGroup) {
            System.out.printf("=================== 开始处理: %d ===================", num);
            System.out.println();
            handler.handle(num);
        }
    }
}
