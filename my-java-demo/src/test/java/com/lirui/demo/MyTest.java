package com.lirui.demo;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock;

public class MyTest {

    private ThreadLocal threadLocal = new ThreadLocal();

    private ThreadLocalRandom random;

    private CountDownLatch latch;

    public MyTest() {
    }

    @Test
    public void test() throws InterruptedException {
        latch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            Thread th = new MyRunner(random.nextInt());
            th.start();
        }
        latch.await();
        System.out.println("finished");
    }

    private class MyRunner extends Thread {

        private int num;

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
            latch.countDown();
        }
    }

    @Test
    public void test1() {
        ConcurrentHashMap hashMap = new ConcurrentHashMap();
        ReentrantLock lock = new ReentrantLock();
        HashMap map = new HashMap();
        map.put(null, null);
        LinkedList linkedList = new LinkedList();
        Hashtable hashtable = new Hashtable();
    }
}
