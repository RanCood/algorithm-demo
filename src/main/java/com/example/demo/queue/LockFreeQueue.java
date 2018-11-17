package com.example.demo.queue;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * @author zg
 * @date 2018/11/15
 */
public class LockFreeQueue {
    private final static LockFreeQueue queue = new LockFreeQueue(9000000);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Add());
        t1.start();
        Thread.sleep(3000);
        System.out.println("暂停3000毫秒");

        Thread t2 = new Thread(new Poll());
        Thread t3 = new Thread(new Poll());
        Thread t4 = new Thread(new Poll());
        Thread t5 = new Thread(new Poll());
        Thread t6 = new Thread(new Poll());
        Thread t7 = new Thread(new Poll());

        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();

        Thread.sleep(1000);

        System.out.println(queue.getHead().get());
    }

    private AtomicReferenceArray atomicReferenceArray;
    //代表为空，没有元素
    private static final Integer EMPTY = null;
    //头指针,尾指针
    AtomicInteger head, tail;

    public AtomicInteger getTail() {
        return tail;
    }

    public AtomicInteger getHead() {
        return head;
    }

    public LockFreeQueue(int size) {
        atomicReferenceArray = new AtomicReferenceArray(new Integer[size + 1]);
        head = new AtomicInteger(0);
        tail = new AtomicInteger(0);
    }

    /**
     * 入队
     *
     * @param element
     * @return
     */
    public boolean add(Integer element) {
        int index = (tail.get() + 1) % atomicReferenceArray.length();
        if (index == head.get() % atomicReferenceArray.length()) {
            System.out.println("当前队列已满," + element + "无法入队!");
            return false;
        }
        while (!atomicReferenceArray.compareAndSet(index, EMPTY, element)) {
            return add(element);
        }
        tail.incrementAndGet(); //移动尾指针
//        System.out.println("入队成功!" + element);
        return true;
    }

    /**
     * 出队
     *
     * @return
     */
    public Integer poll() {
        if (head.get() == tail.get()) {
            System.out.println("当前队列为空");
            return null;
        }
        int index = (head.get() + 1) % atomicReferenceArray.length();
        Integer ele = (Integer) atomicReferenceArray.get(index);
        if (ele == null) { //有可能其它线程也在出队
            return null;
        }
        while (!atomicReferenceArray.compareAndSet(index, ele, EMPTY)) {
            return poll();
        }
        head.incrementAndGet();
//        System.out.println(head.get());
        return ele;
    }

    public void print() {
        StringBuffer buffer = new StringBuffer("[");
        for (int i = 0; i < atomicReferenceArray.length(); i++) {
            if (i == head.get() || atomicReferenceArray.get(i) == null) {
                continue;
            }
            buffer.append(atomicReferenceArray.get(i) + ",");
        }
        buffer.deleteCharAt(buffer.length() - 1);
        buffer.append("]");
        System.out.println("队列内容:" + buffer.toString());

    }

    public static class Add implements Runnable {
        @Override
        public void run() {
            long start = System.currentTimeMillis();
            Integer i = 8000000;
            while (i > 0) {
                queue.add(i);
                i--;
            }
            System.out.println(Thread.currentThread().getId()+"===插入8000000数据时间："+ (System.currentTimeMillis() - start));
        }
    }

    public static class Poll implements Runnable {
        @Override
        public void run() {
            long start = System.currentTimeMillis();
            Integer i = 1000000;
            while (i > 0) {
                queue.poll();
                i--;
            }
            System.out.println(Thread.currentThread().getId()
                    +"===poll 1000000 数据时间："+ (System.currentTimeMillis() - start)+",head="+queue.getHead().get());

        }
    }
}

