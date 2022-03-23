package com.zg.link;

/**
 * @author zg
 * @date 2018/11/7 14:59
 */
public class Linked4 {

    public static void main(String[] args) {

        Node var5 = createNode(9, null);
        Node var4 = createNode(8, var5);
        Node var1 = createNode(2, var4);
        Node var2 = createNode(6, var1);
        Node var3 = createNode(9, var2);
        Node var6 = createNode(22, var3);
        Node node = createNode(1, var6);
//        printNode(node);
//        deleteLastKth(node, 11);
        reverse(node);
//        findMiddleNode(node);
//        var5.next = var3;
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
        Node head = null;
        Node crrent = list;
        Node pre = null;
        while (crrent != null) {
            Node next = crrent.next;
            if (next == null) {
                head = crrent;
            }
            crrent.next = pre;
            pre = crrent;
            crrent = next;
        }
        printNode(head);
    }

    public static void deleteLastKth(Node list, int k) {
        if (k < 1) {
            printNode(list);
            return;
        }
        Node fast = list;
        Node slow = list;
        int i = 0;
        while (fast.next != null && i < k) {
            fast = fast.next;
            i++;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        if (fast.next == null && i < k) {
            list = slow.next;
        } else {
            slow.next = slow.next.next;
        }
        printNode(list);
    }

    public static Boolean checkCircle(Node list) {
        Node fast = list;
        Node slow = list;
        while (fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void mergeSortedLists(Node list1, Node list2) {

    }

    public static Node createNode(int data, Node next) {
        return new Node(data, next);
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

