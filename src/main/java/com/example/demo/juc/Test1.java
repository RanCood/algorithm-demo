package com.example.demo.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: zg
 * @date: 2019/12/30 16:41
 */
public class Test1 {
    public static void main(String[] args) {
        /* StampedLock */
//        StampedLock sl = new StampedLock();
//        long stamp = sl.tryOptimisticRead();
//        // 做了一堆操作之后,校验stamp是否改变过
//        if(!sl.validate(stamp)) {
//            stamp = sl.readLock();
//            try{
//
//            } finally {
//                sl.unlockRead(stamp);
//            }
//        }
//
//        long wl = sl.writeLock();
//        try{
//
//        }finally {
//            sl.unlockWrite(wl);
//        }
        /* StampedLock */

        /*---------------------------*/

        /* ReadWriteLock */
        ReadWriteLock rwl = new ReentrantReadWriteLock();
        Lock rl = rwl.readLock();
        Lock wl = rwl.writeLock();
        rl.lock();
        try{

        }finally {
            rl.unlock();
        }
        wl.lock();
        try{

        }finally {
            rl.unlock();
        }
        /* ReadWriteLock */


        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(800);
        MyThreadPool pool = new MyThreadPool(4, queue);
        for (int i=0;i<100;i++) {
            pool.execute(() -> {
                System.out.println(Thread.currentThread().getName());
            });
        }
    }
}

class MyThreadPool {
    private BlockingQueue<Runnable> workQueue;
    private List<Runnable> workThreads = new ArrayList<>();

    public MyThreadPool(int poolSize, BlockingQueue<Runnable> workQueue) {
        this.workQueue = workQueue;
        for (int i = 0; i < poolSize; i++) {
            WorkThread work = new WorkThread();
            work.start();
            this.workThreads.add(work);
        }
    }

    void execute(Runnable command) {
        while (workQueue.size()<8) {
            workQueue.add(command);
        }
    }

    class WorkThread extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Runnable take = workQueue.take();
                    take.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}