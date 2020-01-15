package com.example.demo.link;

import com.mysql.cj.xdevapi.WarningImpl;
import sun.security.util.Length;

/**
 * @author zg
 * @date 2018/11/7 14:59
 */
public class Linked2 {

    public static void main(String[] args) {

        Node var5 = createNode(9, null);
        Node var4 = createNode(8, var5);
        Node var1 = createNode(2, var4);
        Node var2 = createNode(6, var1);
        Node var3 = createNode(9, var2);
        Node node = createNode(1, var3);
//        var5.next = var3;
//        printNode(node);
//        deletelastKth(node, 3);
//        reverse(node);
//        findMiddleNode(node);
        bubbleSort(node);
        System.out.println(checkCircle(node));

    }

    /**
     * 冒泡排序
     *
     * @param list
     */
    public static void bubbleSort(Node list) {
        int length = 0;
        Node len = list;
        while (len != null) {
            len = len.next;
            length++;
        }
        Node pre = null;
        for (int i = 0; i < length; i++) {
            Node node = list;
            while (node.next != null) {
                Node next = node.next;
                if (node.data > next.data) {
                    node.next = next.next;
                    next.next = node;
                    if (pre == null) {
                        next.next = node;
                    } else {
                        pre.next = next;
                    }
                    pre = next;
                } else {
                    pre = node;
                    node = next;
                }
            }
        }
        printNode(list);
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
        Node current = list;
        Node pre = null;
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
        int i = 1;
        while (fast != null && i < k) {
            fast = fast.next;
            i++;
        }
        Node slow = list;
        Node pre = null;
        while (fast.next != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        if (pre == null) {
            list = list.next;
        } else {
            pre.next = pre.next.next;
        }
        printNode(list);
    }


    public static Boolean checkCircle(Node list) {
        Node fast = list;
        Node slow = list;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void mergeSortedLists(Node list1, Node list2) {
        Node q = list1;
        Node p = list2;
        Node head = null;
        if (q.data < p.data) {
            head = q;
            q = q.next;
        } else {
            head = p;
            p = p.next;
        }
        Node cur = head;
        while (q != null && p != null) {
            if (q.data < p.data) {
                cur.next = q;
                q = q.next;
            } else {
                cur.next = p;
                p = p.next;
            }
            cur = cur.next;
        }
        if (q != null) {
            cur.next = q;
        }
        if (p != null) {
            cur.next = p;
        }
        printNode(head);
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

