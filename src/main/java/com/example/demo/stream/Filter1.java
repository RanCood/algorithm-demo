package com.example.demo.stream;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zg
 * @date 2018/12/7 18:29
 */
public class Filter1 {
    public static void main(String[] args) {
//        Stream<Integer> stream = Stream.of(12, 43, 65, 321, 47, 89, 1234, 234);
        Stream<String> str = Stream.of("zg", "zyj", "wjx", "weh", "hc");
        List<RiskType> collect = str.map(RiskType::new).collect(Collectors.toList());
        Optional<String> reduce = collect.stream().map(RiskType::getName).reduce((n1, n2) -> n1 + "，" + n2);
        System.out.println(reduce.get());
//        stream.filter(value -> value > 100).forEach(System.out::println);
//        str.sorted().forEach(System.out::println);

//        Stream<String> s = Stream.of("test", "t1", "t2", "e", "aaa");
//        s.flatMap(n -> Stream.of(n.split(""))).forEach(System.out::println);
//        s.map(n -> Stream.of(n.split(""))).forEach(System.out::println);
    }
}
