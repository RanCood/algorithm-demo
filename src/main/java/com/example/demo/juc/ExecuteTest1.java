package com.example.demo.juc;

import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: zg
 * @date: 2019/12/31 11:03
 */
public class ExecuteTest1 {
    private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 5
            , TimeUnit.SECONDS, new LinkedBlockingQueue<>(50), new CustomizableThreadFactory(),new ThreadPoolExecutor.DiscardOldestPolicy());


    public static void main(String[] args) {
        executor.execute(()->{

        });
    }


    static class CustomThreadName implements ThreadFactory {
        final AtomicInteger count = new AtomicInteger();
        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r, "zg-thread-" + count.getAndIncrement());
        }
    }

    static class handler implements RejectedExecutionHandler{

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        }
    }

}
