package com.example.demo.juc;

import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import javax.security.auth.callback.Callback;
import java.util.concurrent.*;

/**
 * @author: zg
 * @date: 2019/12/31 14:29
 */
public class FutureTaskTest1 {

//    private static final ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 5
//            , TimeUnit.SECONDS, new LinkedBlockingQueue<>(50), new CustomizableThreadFactory(),new ThreadPoolExecutor.DiscardOldestPolicy());


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> ft1 = new FutureTask<>(new Task2());
        FutureTask<String> ft2 = new FutureTask<>(new Task1(ft1));
        Thread t1 = new Thread(ft2);
        t1.start();
        Thread t2 = new Thread(ft1);
        t2.start();
//        executor.submit(ft1);
//        executor.submit(ft2);
        System.out.println(ft2.get());
    }

    static class Task1 implements Callable<String> {
        private Future<String> task2;

        public Task1(Future task) {
            this.task2 = task;
        }

        @Override
        public String call() throws Exception {
            System.out.println("洗水壶。。。。");

            System.out.println("烧水。。。。");
            String tea = task2.get();
            System.out.println("拿到茶叶：" + tea);
            System.out.println("泡茶。。。");
            return "上茶:" + tea;
        }
    }

    static class Task2 implements Callable<String> {
        @Override
        public String call() throws Exception {
            System.out.println("洗茶壶。。。。");
            System.out.println("烧茶杯。。。。");
            System.out.println("那茶叶。。。。");
            return "龙井";
        }
    }
}
