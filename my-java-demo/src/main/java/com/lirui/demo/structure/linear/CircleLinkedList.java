package com.lirui.demo.structure.linear;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 约瑟夫（丢手绢）问题
 * @author Ryan
 */
public class CircleLinkedList {

    public static void main(String[] args) {
        CLinkedList cLinkedList = new CLinkedList();
        for (int i = 1; i < 23; i ++) {
            cLinkedList.offer(new CLinkedList.Node(i));
        }
        cLinkedList.print();
        System.out.println("------------------------- loop poll ---------------------------");
        cLinkedList.loopPoll(3,7);
    }
}

class CLinkedList {

    Node head;

    public void offer(Node node) {
        if (head == null) {
            head = node;
            node.next = head;
            return;
        }
        Node current = head;
        while (!current.next.equals(head)) {
            current = current.next;
        }
        current.next = node;
        node.next = head;
    }

    public void print() {
        Node temp = head;
        while (!temp.next.equals(head)) {
            System.out.println(temp);
            temp = temp.next;
        }
        System.out.println(temp);
    }

    public void loopPoll(int start, int interval){
        Node current = head;
        for (int i = 1; i < start; i ++) {
            current = current.next;
        }
        List<Integer> loopNum = new ArrayList<>();
        while (current != null) {
            for (int i = 1; i < interval - 1; i ++) {
                current = current.next;
            }
            loopNum.add(current.next.data);
            if (current == current.next) {
                head = null;
                break;
            }
            current.next = current.next.next;
            current = current.next;
        }
        System.out.println(loopNum.toString());
    }

    @Data
    static class Node {

        private int data;

        private Node next;

        public Node(int data) {
            this.data = data;
        }

        @Override
        public int hashCode(){
            return data;
        }

        @Override
        public boolean equals(Object o) {
            boolean flag = false;
            if (o instanceof Node) {
                flag = ((Node) o).data == this.data;
            }
            return flag;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }
}
