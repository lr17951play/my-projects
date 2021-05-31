package com.lirui.demo.lock;

import java.util.concurrent.*;
import java.util.concurrent.locks.StampedLock;

public class MyStampedLock {

    static ExecutorService service = new ThreadPoolExecutor(10, 10,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(),
            Executors.defaultThreadFactory());
    static StampedLock lock = new StampedLock();
    static long milli = 5000;
    static int count = 0;

    public static void main(String[] args) {
        long l1 = System.currentTimeMillis();
//        readLock();
        optimisticRead();
        long l2 = writeLock();
        System.out.println(l2-l1);
    }

    private static void readLock() {//普通的读锁
        service.submit(() -> {
            int currentCount = 0;
            long stamp = lock.readLock(); //获取排他读锁
            try {
                currentCount = count; //获取变量值
                try {
                    TimeUnit.MILLISECONDS.sleep(milli);//模拟读取需要花费20秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } finally {
                lock.unlockRead(stamp); //释放读锁
            }
            System.out.println("readLock==" + currentCount); //显示最新的变量值
        });
        try {
            TimeUnit.MILLISECONDS.sleep(500);//要等一等读锁先获得
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static long writeLock() {
        long stamp = lock.writeLock();
        count+=1;
        lock.unlockWrite(stamp);
        System.out.println("数据写入完成");
        return System.currentTimeMillis();
    }

    private static void optimisticRead() {
        service.submit(() -> {
            long stamp = lock.tryOptimisticRead(); //尝试获取乐观读锁
            int currentCount = count; //获取变量值
            try {
                TimeUnit.MILLISECONDS.sleep(milli);//模拟读取需要花费20秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!lock.validate(stamp)) { //判断count是否进入写模式
                stamp = lock.readLock(); //已经进入写模式，没办法只能老老实实的获取读锁
                try {
                    currentCount = count; //成功获取到读锁，并重新获取最新的变量值
                } finally {
                    lock.unlockRead(stamp); //释放读锁
                }
            }
            //走到这里，说明count还没有被写，那么可以不用加读锁，减少了读锁的开销
            System.out.println("optimisticRead==" + currentCount); //显示最新的变量值
        });
        try {
            TimeUnit.MILLISECONDS.sleep(500);//要等一等读锁先获得
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
