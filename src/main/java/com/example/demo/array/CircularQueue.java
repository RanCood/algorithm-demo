package com.example.demo.array;

/**
 * @author zg
 * @date 2019/2/1
 */
public class CircularQueue {
    private String[] items;
    private Integer n;
    private Integer head;
    private Integer tail;

    public CircularQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    public Boolean enqueue(String value) {
        if ((tail + 1) / n == head) {
            return null;
        }
        items[tail] = value;
        tail = (tail + 1) % n;
        return true;
    }

    public String dequeue() {
        if (head.equals(tail)) {
            return null;
        }
        String ret = items[head];
        head = (head + 1) % n;
        return ret;
    }
}
