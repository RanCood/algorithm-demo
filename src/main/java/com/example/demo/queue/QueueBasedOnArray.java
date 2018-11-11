package com.example.demo.queue;

/**
 * @author zg
 * @date 2018/11/11
 */
public class QueueBasedOnArray {
    public static void main(String[] args) {
        QueueBasedOnArray queue = new QueueBasedOnArray(5);
        queue.enqueue("xqy");
        queue.enqueue("zfw");
        queue.enqueue("zx");
        queue.enqueue("zyj");
        queue.enqueue("zg");

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());

        System.out.println("head:" + queue.head);
        System.out.println("tail:" + queue.tail);

        System.out.println("============");
        queue.enqueue("eee");
        queue.enqueue("rrr");
        queue.enqueue("ttt");

        System.out.println("head:" + queue.head);
        System.out.println("tail:" + queue.tail);
    }

    private String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public Boolean enqueue(String value) {
        if (tail == n) {
            if (head == 0) {
                return false;
            }
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            tail -= head;
            head = 0;
        }

        items[tail] = value;
        ++tail;
        return true;
    }

    public String dequeue() {
        if (head == tail) {
            return null;
        }
        String item = items[head];
        ++head;
        return item;
    }

    public QueueBasedOnArray(int capacity) {
        this.items = new String[capacity];
        n = capacity;
    }
}
