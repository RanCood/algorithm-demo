package com.example.demo.link;

/**
 * @author zg
 * @date 2018/11/8
 */
public class LinkedBase {
    private static Node head = null;

    public static void main(String[] args) {

    }

    public static void findByValue(int value) {
        Node p = head;
        int i = 1;
        while (p != null && p.data != value) {
            p = p.next;
            i++;
        }
        System.out.println(i);
    }

    public Node findByIndex(int index) {
        Node p = head;
        int i = 1;
        while (p != null && i != index) {
            p = p.next;
            i++;
        }
        return p;
    }

    public void insertToHead(int value) {
        Node newNode = new Node(value, null);
        insertToHead(newNode);
    }

    private void insertToHead(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertAfter(Node p, int value) {
        Node newNode = new Node(value, null);
        insertAfter(p,newNode);
    }

    public void insertAfter(Node p, Node newNode){
        if (p == null) {
            return;
        }
        newNode.next = p.next;
        p.next = newNode;
    }

    public void insertBefore(Node p, int value) {
        Node newNode = new Node(value, null);
        insertBefore(p, newNode);
    }

    public void insertBefore(Node p, Node newNode) {
        if(p == null) {
            return;
        }
        if(head == p){
            insertToHead(newNode);
            return;
        }
        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }
        if (q == null) {
            return;
        }

        newNode.next = p;
        q.next = newNode;
    }

    public void deleteByNode(Node p) {
        if (p == null || head == null) {
            return;
        }
        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }
        if (q == null) {
            return;
        }

        q.next = q.next.next;
    }

    public void deleteByValue(int value) {
        if (head == null) {
            return;
        }

        Node p = head;
        Node q = null;
        while (p != null && p.data != value) {
            q = p;
            p = p.next;
        }

        if (p == null) {
            return;
        }

        if (q == null) {
            head = head.next;
        } else {
            q.next = q.next.next;
        }

        // 可重复删除指定value的代码
    /*
    if (head != null && head.data == value) {
    	head = head.next;
    }
    Node pNode = head;
    while (pNode != null) {
    	if (pNode.next.data == data) {
    		pNode.next = pNode.next.next;
    		continue;
    	}
    	pNode = pNode.next;
    }
    */
    }

    public static void printNode(Node node) {
        Node p = node;
        while (p != null) {
            System.out.print(p.data + "->");
            p = p.next;
        }
        System.out.println();
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }


    }
}
