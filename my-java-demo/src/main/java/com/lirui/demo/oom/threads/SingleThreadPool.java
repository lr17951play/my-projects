package com.lirui.demo.oom.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SingleThreadPool {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        AtomicInteger i = new AtomicInteger();
        while (true) {
            executor.submit(() -> {
                System.out.println("线程执行------------------------>" + i.getAndIncrement());
            });
        }
    }
}
