package com.lirui.demo.oom.simple;

import java.util.ArrayList;
import java.util.List;

public class HeapError {

    static List<Object> list = new ArrayList<>();

    public static void main(String[] args) {
        int a = 0;
        while (true) {
            System.out.println("这是第 "+ a++ +" 次调用");
            list.add(a);
        }
    }

}
