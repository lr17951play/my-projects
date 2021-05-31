package com.lirui.demo.oom.simple;

import java.util.concurrent.atomic.AtomicInteger;

public class StarkError {

    public static void main(String[] args) {
        AtomicInteger a = new AtomicInteger();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    test(a);
                }
            });
            thread.start();
        }
    }

    private static void test(AtomicInteger a) {
        a.getAndIncrement();
        System.out.println("这是第 "+a+" 次调用");
        test(a);
    }
}
