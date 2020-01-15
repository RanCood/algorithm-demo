package com.example.demo.juc;

import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: zg
 * @date: 2020/1/2 11:51
 */
public class CompeltionServiceTest1 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Random rd = new Random();

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CompletionService<String> cs = new ExecutorCompletionService<String>(executorService);
        cs.submit(()->{
            TimeUnit.SECONDS.sleep(rd.nextInt(10));
            return "1111";});
        cs.submit(()->{
            TimeUnit.SECONDS.sleep(rd.nextInt(10));
            return "2222";});
        cs.submit(()->{
            TimeUnit.SECONDS.sleep(rd.nextInt(10));
            return "333";});
        cs.submit(()->{
            TimeUnit.SECONDS.sleep(rd.nextInt(10));
            return "44";});
        for (int i=0;i<4;i++) {
            String s = cs.take().get();
            System.out.println(s);
        }

        AtomicInteger ai = new AtomicInteger(Integer.MIN_VALUE);
        int andIncrement = ai.getAndIncrement();
    }
}
