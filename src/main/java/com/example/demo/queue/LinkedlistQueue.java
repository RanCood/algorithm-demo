package com.example.demo.queue;

/**
 * @author zg
 * @date 2018/11/11
 */
public class LinkedlistQueue {

    public static void main(String[] args) {
        LinkedlistQueue queue = new LinkedlistQueue();
        queue.enqueue("xqy");
        queue.enqueue("zfw");
        queue.enqueue("zx");
        queue.enqueue("zyj");
        queue.enqueue("zg");

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

    private Node head = null;
    private Node tail = null;

    public Boolean enqueue(String value) {
        Node newNode = new Node(value, null);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
        return true;
    }

    public String dequeue() {
        if (head == null) {
            return null;
        }
        String data = head.data;
        head = head.next;
        return data;
    }

    public static class Node {
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }


    }
}
