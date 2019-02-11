package com.example.demo.sort;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zg
 * @date 2019/1/22 15:26
 */
public class Floor {
    public static Map<String, Long> step = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        System.out.println(floorStep(200));
        System.out.println(System.currentTimeMillis() - l);
    }

    public static Long floorStep(Integer floor) {
        if (floor == 1) {
            return 1L;
        }
        if (floor == 2) {
            return 2L;
        }
        Long var = step.get(floor + "");
        Long result = 0L;
        if (null == var) {
            result = floorStep(floor - 1) + floorStep(floor - 2);
            step.put(floor + "", result);
        } else {
            return var;
        }
        return result;
    }
}
