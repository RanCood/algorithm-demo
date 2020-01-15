package com.example.demo.link;

/**
 * @author zg
 * @date 2018/11/7 14:59
 */
public class Linked3 {

    public static void main(String[] args) {

        Node var5 = createNode(9, null);
        Node var4 = createNode(8, var5);
        Node var1 = createNode(2, var4);
        Node var2 = createNode(6, var1);
        Node var3 = createNode(9, var2);
        Node node = createNode(1, var3);
//        var5.next = var3;
        printNode(node);
//        deletelastKth(node, 3);
        reverse(node);
//        findMiddleNode(node);
//        System.out.println(checkCircle(node));

    }


    public static void findMiddleNode(Node list) {
        Node fast = list;
        Node slow = list;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        System.out.println(slow.data);
    }

    public static void reverse(Node list) {
        Node current = list;
        Node pre = null;
        Node head = null;
        while (current != null) {
            Node next = current.next;
            if (next == null) {
                head = current;
            }
            current.next = pre;
            pre = current;
            current = next;
        }
        printNode(head);
    }

    public static void deletelastKth(Node list, int k) {
        Node fast = list;
        int i=1;
        while (fast != null&& i<k) {
            fast = fast.next;
            i++;
        }
    }


    public static Boolean checkCircle(Node list) {
        return false;
    }

    public static void mergeSortedLists(Node list1, Node list2) {

    }

    public static Node createNode(int value, Node node) {
        return new Node(value, node);
    }

    public static void printNode(Node node) {
        Node p = node;
        while (p != null) {
            System.out.print(p.getData() + "->");
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

        public int getData() {
            return data;
        }
    }
}

