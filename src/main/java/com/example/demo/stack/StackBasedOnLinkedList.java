package com.example.demo.stack;

/**
 * @author zg
 * @date 2018/11/10
 */
public class StackBasedOnLinkedList {

    public static void main(String[] args) {
        StackBasedOnLinkedList stack = new StackBasedOnLinkedList();
        stack.push(2);
        stack.push(4);
        stack.push(23);
        stack.push(67);
        stack.printAll();
        stack.pop();
        stack.pop();
        stack.printAll();
    }

    private Node top = null;

    public void push(int value) {
        Node newNode = new Node(value,null);
        if (top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }

    public int pop() {
        if (top == null) {
            return -1;
        } else {
            int value = top.data;
            top = top.next;
            return value;
        }
    }
    public void printAll() {
        Node p = top;
        while (p.next != null) {
            System.out.print(p.data + "->");
            p = p.next;
        }
        System.out.println();
    }
    public class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
