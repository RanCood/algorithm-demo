package com.example.demo.conCurrent;

import java.util.concurrent.CompletableFuture;

import static java.lang.Thread.sleep;

/**
 * @author zg
 * @date 2019/7/19 14:39
 */
public class CompletableFutrueTest {
    public static void main(String[] args){
        CompletableFuture<Void> f1 = CompletableFuture.runAsync(() -> {
            try {
                System.out.println("t1:洗水壶。。。");
                sleep(2);
                System.out.println("t1:烧水。。。");
                sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("t2:洗茶壶。。。");
                sleep(1);
                System.out.println("t2:洗茶杯。。。");
                sleep(2);
                System.out.println("t2:那茶叶。。。");
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "龙井";
        });
        CompletableFuture<String> f3 = f1.thenCombine(f2, (var, tf) -> {
            System.out.println("t3:拿到茶叶。。。");
            System.out.println("t3:泡茶。。。");
            return "上茶:" + tf;
        });
        System.out.println(f3.join());
    }
}
