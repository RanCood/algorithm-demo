package com.example.demo.queue;

/**
 * @author zg
 * @date 2018/11/11
 */
public class QueueBasedOnArray {
    public static void main(String[] args) throws InterruptedException {
        QueueBasedOnArray queue = new QueueBasedOnArray(1000);

        Thread t1 = new Thread(() -> {
            Integer i = 100;
            while (i > 0) {
                if (queue.enqueue(Thread.currentThread().getName() + "-" + i.toString(),queue.getTail())) {
                    i--;
                }
                queue.getTail();
            }
        });
        Thread t2 = new Thread(() -> {
            Integer i = 100;
            while (i > 0) {
                if (queue.enqueue(Thread.currentThread().getName() + "-" + i.toString(),queue.getTail())) {
                    i--;
                }
                queue.getTail();

//                i--;
//                queue.enqueue(Thread.currentThread().getName() + "-" + i.toString());
            }
        });
        Thread t3 = new Thread(() -> {
            Integer i = 100;
            while (i > 0) {
                if (queue.enqueue(Thread.currentThread().getName() + "-" + i.toString(),queue.getTail())) {
                    i--;
                }
                queue.getTail();

            }
        });
        Thread t4 = new Thread(() -> {
            Integer i = 100;
            while (i > 0) {
                if (queue.enqueue(Thread.currentThread().getName() + "-" + i.toString(),queue.getTail())) {
                    i--;
                }
                queue.getTail();
            }
        });
        t4.start();
        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(1000);

//        queue.enqueue("xqy");
//        queue.enqueue("zfw");
//        queue.enqueue("zx");
//        queue.enqueue("zyj");
//        System.out.println(queue.enqueue("zg"));
//        queue.enqueue("yuy");
//        queue.enqueue("iuyo");
//
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//
//
//        System.out.println("head:" + queue.head);
//        System.out.println("tail:" + queue.tail);
//
//        System.out.println("============");
//        queue.enqueue("eee");
//        queue.enqueue("rrr");
//        queue.enqueue("ttt");
//
//        System.out.println("head:" + queue.head);
//        System.out.println("tail:" + queue.tail);
//
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());

        System.out.println(queue.getTail());
    }

    private volatile String[] items;
    private int n = 0;
    private int head = 0;
    private int tail = 0;
    public Boolean enqueue(String value,int tail) {
        int next = (tail + 1) % n;
        if (next == head) {
            return false;
        }
        items[tail] = value;
        this.tail = next;
        return true;

        //        if (tail == n) {
//            if (head == 0) {
//                return false;
//            }
//            for (int i = head; i < tail; i++) {
//                items[i - head] = items[i];
//            }
//            tail -= head;
//            head = 0;
//        }
    }

    public String dequeue() {
        if (head == tail) {
            return null;
        }
        String item = items[head];
        head = (head + 1) % n;
        return item;
    }

    public String[] getItems() {
        return items;
    }

    public int getTail() {
        return tail;
    }

    public QueueBasedOnArray(int capacity) {
        this.items = new String[capacity];
        n = capacity;
    }
}
