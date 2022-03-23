package com.zg.link;

/**
 * @author zg
 * @date 2018/11/7 14:59
 */
public class Linked1 {

    public static void main(String[] args) {

        Node var5 = createNode(9, null);
        Node var4 = createNode(8, var5);
        Node var1 = createNode(2, var4);
        Node var2 = createNode(6, var1);
        Node var3 = createNode(9, var2);
        Node node = createNode(1, var3);
//        printNode(node);
        deletelastKth(node, 33);
//        reverse(node);
//        findMiddleNode(node);
//        var5.next = var3;
//        System.out.println(checkCircle(node));
    }

    public static void findMiddleNode(Node list) {
        if (list == null) {
            return;
        }

        Node fast = list;
        Node slow = list;

        while (fast.next != null && fast.next.next != null) {
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

        if (fast == null) {
            printNode(list);
            return;
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
        if (list == null) {
            return false;
        }
        Node fast = list.next;
        Node slow = list.next;

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
        Node r = head;

        while (q != null && p != null) {
            if (q.data < p.data) {
                r.next = q;
                q = q.next;
            } else {
                r.next = p;
                p = p.next;
            }
            r = r.next;
        }

        if (q != null) {
            r.next = q;
        } else {
            r.next = p;
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

