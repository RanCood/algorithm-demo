package com.example.demo.metrics;


import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.simple.SimpleMeterRegistry;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zg
 * @date 2019/2/14 11:01
 */
public class CounterSample {
    public static void main(String[] args) {
        Counter counter = Counter.builder("counter")
                .tag("tag1", "tag1")
                .description("counter")
                .register(new SimpleMeterRegistry());
        counter.increment();
        counter.increment(2D);
        System.out.println(counter.count());
        System.out.println(counter.measure());
        //全局静态方法
        Metrics.addRegistry(new SimpleMeterRegistry());
        counter = Metrics.counter("counter", "tag1", "tag1");
        counter.increment(10086D);
        counter.increment(10087D);
        System.out.println(counter.count());
        System.out.println(counter.measure());


        AtomicInteger atomicInteger = new AtomicInteger();
        Gauge gauge = Gauge.builder("gauge", atomicInteger, AtomicInteger::get)
                .tag("gauge", "gauge")
                .description("gauge")
                .register(new SimpleMeterRegistry());
        atomicInteger.addAndGet(5);
        System.out.println(gauge.value());
        System.out.println(gauge.measure());
        atomicInteger.decrementAndGet();
        System.out.println(gauge.value());
        System.out.println(gauge.measure());
        //全局静态方法，返回值竟然是依赖值，有点奇怪，暂时不选用
        Metrics.addRegistry(new SimpleMeterRegistry());
        AtomicInteger other = Metrics.gauge("gauge", atomicInteger, AtomicInteger::get);
    }
}
