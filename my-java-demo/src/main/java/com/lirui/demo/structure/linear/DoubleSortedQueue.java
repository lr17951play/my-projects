package com.lirui.demo.structure.linear;

/**
 * @author Ryan
 */
public class DoubleSortedQueue {

    static DLinkedQueue.Node node1 = new DLinkedQueue.Node(1, "1");
    static DLinkedQueue.Node node2 = new DLinkedQueue.Node(2, "2");
    static DLinkedQueue.Node node3 = new DLinkedQueue.Node(3, "3");
    static DLinkedQueue.Node node4 = new DLinkedQueue.Node(4, "4");
    static DLinkedQueue.Node node5 = new DLinkedQueue.Node(5, "5");
    static DLinkedQueue.Node node6 = new DLinkedQueue.Node(6, "6");
    static DLinkedQueue.Node node7 = new DLinkedQueue.Node(7, "7");
    static DLinkedQueue.Node node8 = new DLinkedQueue.Node(8, "8");
    static DLinkedQueue.Node node9 = new DLinkedQueue.Node(9, "9");
    static DLinkedQueue.Node node10 = new DLinkedQueue.Node(10, "10");

    public static void main(String[] args) {
        DLinkedQueue queue = new DLinkedQueue();
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
        System.out.println("---------------------- reverse print ----------------------");
        queue.reversePrint();

        System.out.println("---------------------- polling ----------------------");
        DLinkedQueue.Node node = queue.poll();
        while (node != null) {
            System.out.println(node);
            node = queue.poll();
        }
    }
}

class DLinkedQueue{

    Node head;

    Node tail;

    public void push(Node node) {
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        Node current = head;
        if (head.order > node.order) {
            head = node;
            node.next = current;
            current.prev = node;
            tail = current;
            return;
        }
        while (current.next != null && node.order >= current.next.order) {
            current = current.next;
        }
        Node temp = current.next;
        node.next = temp;
        node.prev = current;
        current.next = node;
        if (temp != null) {
            temp.prev = node;
        } else {
            tail = node;
        }
    }

    public Node poll() {
        Node temp = head;
        if (temp != null) {
            head = temp.next;
            temp.next = null;
            if (head != null) {
                head.prev = null;
            }
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

    public void reversePrint(){
        Node temp = tail;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.prev;
        }
    }

    static class Node {
        private int order;

        private String name;

        private Node next;

        private Node prev;

        public Node(int order, String name) {
            this.order = order;
            this.name = name;
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
