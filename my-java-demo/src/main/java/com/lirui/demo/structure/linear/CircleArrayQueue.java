package com.lirui.demo.structure.linear;

import java.util.Scanner;

/**
 * @author Ryan
 */
public class CircleArrayQueue {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(4);
        while (true) {
            System.out.println("a: add.");
            System.out.println("g: get.");
            System.out.println("l: length.");
            System.out.println("p: print.");
            System.out.println("exit: exit.");
            Scanner scanner = new Scanner(System.in);
            String key = scanner.next();
            switch (key) {
                case "a":
                    System.out.println("请输入入队成员变量:");
                    queue.push(scanner.nextInt());
                    break;
                case "g":
                    try {
                        int value = queue.poll();
                        System.out.println("弹出元素: " + value);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "l":
                    System.out.println("当前长度: " + queue.length());
                    break;
                case "p":
                    queue.printMembers();
                    break;
                default:
                    break;
            }
            if ("exit".equals(key)) {
                break;
            }
        }
        System.out.println("-------------------------> 程序结束...");
    }

}

class ArrayQueue {

    private int maxSize;

    private int head;

    private int tail;

    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.head = 0;
        this.tail = 0;
    }

    private boolean isFull(){
        return length() == maxSize;
    }

    private boolean isEmpty(){
        return head == tail;
    }

    public void push(int value){
        if (isFull()) {
            System.out.println("-------------------------> 队列已满...");
            return;
        }
        arr[tail++%maxSize] = value;
    }

    public int poll(){
        if (isEmpty()) {
            throw new RuntimeException("-------------------------> 数组为空...");
        }
        int value = arr[head++%maxSize];
        return value;
    }

    public int length(){
        return tail - head;
    }

    public void printMembers(){
        if (isEmpty()) {
            System.out.println("-------------------------> 数组为空...");
            return;
        }
        System.out.println("当前数组成员：");
        for (int i = head; i < tail; i ++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }
}
