package com.lirui.demo.pool.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Runnable 无返回值，可直接使用 #UncaughtExceptionHandler 进行异常获取
 * @author Ryan
 */
public class RunnableTest {

    private static final int CORE_THREAD = 2;

    private static final int MAX_THREAD = 10;

    private static AtomicInteger num = new AtomicInteger(1);

    public static void main(String[] args) {
        BlockingQueue queue = new LinkedBlockingDeque(10);
        ThreadFactory factory = new ThreadFactoryBuilder()
                .setNameFormat("my-runnable-pool-%d")
                .setUncaughtExceptionHandler((Thread t, Throwable e) -> {
                    System.out.println(t.getName() + " errors cause by: " + e.getMessage());
                })
                .build();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                CORE_THREAD, MAX_THREAD, 10L,
                TimeUnit.SECONDS, queue, factory, new ThreadPoolExecutor.AbortPolicy());

        MyTask task = new MyTask();
        for (int i = 1; i <= 10; i++) {
            executor.execute(task);
        }
        executor.shutdown();
    }

    static class MyTask implements Runnable {

        @Override
        public void run() {
            int current = num.getAndIncrement();
            System.out.println(Thread.currentThread().getName() + " --------> num: " + current);
            if (current == 8) {
                throw new RuntimeException("ERRORS NUM IS 8");
            }
        }
    }
}
