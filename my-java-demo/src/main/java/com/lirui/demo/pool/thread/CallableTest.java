package com.lirui.demo.pool.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Callable 有返回值，且错误不会立即报出而是先暂存，由 Future.get 抛出，因此异常捕获器无法及时捕获，由 AfterExecute 代替
 * @author Ryan
 */
public class CallableTest {

    private static final int CORE_THREAD = 2;

    private static final int MAX_THREAD = 10;

    private static AtomicInteger num = new AtomicInteger(1);

    public static void main(String[] args) {

        BlockingQueue queue = new LinkedBlockingDeque(10);
        ThreadFactory factory = new ThreadFactoryBuilder()
                .setNameFormat("my-callable-pool-%s")
                .build();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(CORE_THREAD, MAX_THREAD,
                10L, TimeUnit.SECONDS,
                queue, factory, new ThreadPoolExecutor.AbortPolicy()) {
            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                if (r instanceof FutureTask) {
                    try {
                        Object o = ((FutureTask<?>) r).get();
                        System.out.println(o);
                    } catch (InterruptedException e) {
                        System.out.println("THIS IS InterruptedException CAUGHT BY AFTEREXECUTE, ERRORS CAUSED BY: " + e.getMessage());
                        Thread.currentThread().interrupt();
                    } catch (ExecutionException e) {
                        System.out.println("THIS IS ExecutionException CAUGHT BY AFTEREXECUTE, ERRORS CAUSED BY: " + e.getMessage());
                    }
                }
            }
        };
        MyTask task = new MyTask();
        for (int i = 1; i <= 10; i++) {
            executor.submit(task);
        }
        executor.shutdown();
    }

    static class MyTask implements Callable {

        @Override
        public String call() {
            int current = num.getAndIncrement();
            if (current == 8) {
                throw new RuntimeException("NUM IS 8");
            }
            return Thread.currentThread().getName() + " ENDS BY NUM IS: " + current;
        }
    }
}
