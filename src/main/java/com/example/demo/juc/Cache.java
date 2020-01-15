package com.example.demo.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: zg
 * @date: 2019/12/30 18:51
 */
public class Cache<K, V> {
    final Map<K, V> map = new HashMap<>(32);
    final ReadWriteLock rwl = new ReentrantReadWriteLock();
    final Lock rl = rwl.readLock();
    final Lock wl = rwl.writeLock();

    V get(K key) {
        V v = null;
        rl.lock();
        try {
            v = map.get(key);
        } finally {
            rl.unlock();
        }
        if (v == null) {
            //从数据库查询数据
            v = (V) "11";
            put(key, v);
        }
        return v;
    }

    V put(K key, V value) {
        wl.lock();
        try {
            return map.put(key, value);
        } finally {
            wl.unlock();
        }
    }
}
