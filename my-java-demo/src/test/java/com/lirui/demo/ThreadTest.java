package com.lirui.demo;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest {

    private final ThreadLocal threadLocal = new ThreadLocal();

    private final ThreadLocalRandom random = ThreadLocalRandom.current();

    private CountDownLatch latch;

    @Test
    public void testRandom() throws InterruptedException {
        latch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            Thread th = new Thread(new MyRunner(random.nextInt()));
            th.start();
        }
        latch.await();
        System.out.println("finished");
    }

    private class MyRunner implements Runnable {

        private final int num;

        MyRunner(int num) {
            this.num = num;
        }

        @SneakyThrows
        @Override
        public void run() {
            threadLocal.set(num);
            System.out.println(Thread.currentThread().getName() + " start------>" + threadLocal.get());
            Thread.sleep(1000L);
            System.out.println(Thread.currentThread().getName() + " end------>" + threadLocal.get());
            threadLocal.remove();
            latch.countDown();
        }
    }

    AtomicInteger num = new AtomicInteger(0);

    @SneakyThrows
    @Test
    public void testWait() {
        latch = new CountDownLatch(2);
        Thread th1 = new Thread(new MyRunner2());
        Thread th2 = new Thread(new MyRunner2());
        th1.start();
        th2.start();
        latch.await();
        System.out.println("finished");
    }

    private class MyRunner2 implements Runnable {

        @SneakyThrows
        @Override
        public void run() {
            synchronized (num) {
                System.out.println(Thread.currentThread().getName() + " start------>");
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(200L);
                    System.out.println(num.incrementAndGet());
                    if (num.get() == 5) {
                        num.wait();
                    }
                }
                num.notify();
            }
            System.out.println(Thread.currentThread().getName() + " end------>");
            latch.countDown();
        }
    }

    @SneakyThrows
    @Test
    public void testJoin() {
        Thread th1 = new Thread(new MyRunner3());
        Thread th2 = new Thread(new MyRunner3());
        th1.start();
        th1.join();
        th2.start();
        th2.join();
        System.out.println("finished");
    }

    private class MyRunner3 implements Runnable {
        @SneakyThrows
        @Override
        public void run() {
                System.out.println(Thread.currentThread().getName() + " start------>");
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(200L);
                    System.out.println(i);
                }
            System.out.println(Thread.currentThread().getName() + " end------>");
        }
    }
}
