package com.lirui.demo.oom.threads;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class CachedThreadPool {


    public static void main(String[] args) {

        List<String> a = new ArrayList();
        List b = new LinkedList();

        ExecutorService executor = Executors.newCachedThreadPool();

        AtomicInteger i = new AtomicInteger();
        while (true) {
            executor.submit(() -> {
                System.out.println("线程执行------------------------>" + i.getAndIncrement());
            });
        }
    }
}
