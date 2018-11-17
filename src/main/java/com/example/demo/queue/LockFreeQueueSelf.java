package com.example.demo.queue;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * @author zg
 * @date 2018/11/15
 */
public class LockFreeQueueSelf {
    public static void main(String[] args) {
//        LockFreeQueueSelf queueSelf = new LockFreeQueueSelf(30);
//        queueSelf.enqueue("我的");
//        queueSelf.enqueue("你的");
//        queueSelf.enqueue("他的");
//
//        queueSelf.dequeue();
        AtomicReferenceArray arr = new AtomicReferenceArray(10);
        arr.compareAndSet(0,null,2);
        System.out.println(arr.length());
        System.out.println(arr.get(0));
    }

    private AtomicReferenceArray<String> atomicReferenceArray;
    private final static String EMPTY = null;
    private AtomicInteger head, tail;

    LockFreeQueueSelf(int size) {
        atomicReferenceArray = new AtomicReferenceArray(size);
        head = new AtomicInteger(0);
        tail = new AtomicInteger(0);
    }

    public boolean enqueue(String element) {
        int index = (tail.get() + 1) % atomicReferenceArray.length();
        if (index == (head.get() % atomicReferenceArray.length())) {
            System.out.println("队列已满");
            return false;
        }
        while (!atomicReferenceArray.compareAndSet(tail.get(), EMPTY, element)) {
            return enqueue(element);
        }
        tail.incrementAndGet();
        System.out.println("入队成功!" + element);
        return true;
    }

    public String dequeue() {
        if (head.get() == tail.get()) {
            System.out.println("队列为空");
            return null;
        }
//        int index = (head.get() + 1) % atomicReferenceArray.length();
        String ele = atomicReferenceArray.get(head.get());
        if (ele == null) {
            return dequeue();
        }
        while (!atomicReferenceArray.compareAndSet(head.get(), ele, EMPTY)) {
            return dequeue();
        }
        head.incrementAndGet();
        System.out.println("出队成功=" + ele);
        return ele;
    }
}
