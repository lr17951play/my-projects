package com.lirui.demo.queue;

import java.util.concurrent.ArrayBlockingQueue;

public class Demo {

    public static void main(String[] args) {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(3);
        queue.offer("1");
        queue.poll();
    }
}
