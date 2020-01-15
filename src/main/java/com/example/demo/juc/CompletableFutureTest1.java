package com.example.demo.juc;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author: zg
 * @date: 2019/12/31 17:38
 */
public class CompletableFutureTest1 {
    private static final Random RANDOM = new Random();
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(()->{
            int i = RANDOM.nextInt(10);
            try {
                TimeUnit.SECONDS.sleep(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("cf："+i);
            return i;
        });
        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(()->{
            int i = RANDOM.nextInt(10);
            try {
                TimeUnit.SECONDS.sleep(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("cf1："+i);
            return i;
        });
        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(()->{
            int i = RANDOM.nextInt(10);
            try {
                TimeUnit.SECONDS.sleep(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("cf2："+i);
            return i;
        });
        // 并行
        CompletableFuture<Integer> future = cf.applyToEither(cf1.applyToEither(cf2, s -> s), s -> s);
        // 串行
        // 汇聚
        System.out.println(future.join());
    }
}
