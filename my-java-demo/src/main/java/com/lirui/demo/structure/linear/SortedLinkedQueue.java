package com.lirui.demo.structure.linear;

import lombok.Data;

/**
 * @author Ryan
 */
public class SortedLinkedQueue {

    static LinkedQueue.Node node1 = new LinkedQueue.Node(1, "1");
    static LinkedQueue.Node node2 = new LinkedQueue.Node(2, "2");
    static LinkedQueue.Node node3 = new LinkedQueue.Node(3, "3");
    static LinkedQueue.Node node4 = new LinkedQueue.Node(4, "4");
    static LinkedQueue.Node node5 = new LinkedQueue.Node(5, "5");
    static LinkedQueue.Node node6 = new LinkedQueue.Node(6, "6");
    static LinkedQueue.Node node7 = new LinkedQueue.Node(7, "7");
    static LinkedQueue.Node node8 = new LinkedQueue.Node(8, "8");
    static LinkedQueue.Node node9 = new LinkedQueue.Node(9, "9");
    static LinkedQueue.Node node10 = new LinkedQueue.Node(10, "10");

    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();
        queue.push(node3);
        queue.push(node1);
        queue.push(node4);
        queue.push(node2);
        queue.push(node8);
        queue.push(node7);
        queue.push(node10);
        queue.push(node5);
        queue.push(node9);
        queue.push(node6);
        System.out.println("---------------------- origin ----------------------");
        queue.print();
        queue.reverse();
        System.out.println("---------------------- reverse ----------------------");
        queue.print();

        System.out.println("---------------------- polling ----------------------");
        LinkedQueue.Node node = queue.poll();
        while (node != null) {
            System.out.println(node);
            node = queue.poll();
        }
    }
}

class LinkedQueue {

    private Node head;

    public void push(Node node) {
        if (head == null) {
            head = node;
            return;
        }
        Node current = head;
        if (head.order > node.order) {
            head = node;
            node.next = current;
            return;
        }
        while (current.next != null && node.order >= current.next.order) {
            current = current.next;
        }
        Node temp = current.next;
        node.next = temp;
        current.next = node;
    }

    public Node poll() {
        Node temp = head;
        if (temp != null) {
            head = temp.next;
            temp.next = null;
        }
        return temp;
    }

    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    public void reverse(){
        if (head == null) {
            System.out.println("链表为空...");
        }
        Node current = head;
        Node reverse = null, temp = null;
        while (current != null) {
            reverse = new Node(current); //reverse head
            reverse.next = temp;
            temp = reverse;
            current = current.next;
        }
        head = reverse;
    }

    @Data
    public static class Node {

        private int order;

        private String name;

        private Node next;

        public Node(int order, String name) {
            this.order = order;
            this.name = name;
        }

        public Node(Node node) {
            this.order = node.order;
            this.name = node.name;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "order=" + order +
                    ", name='" + name +
                    '}';
        }
    }
}




