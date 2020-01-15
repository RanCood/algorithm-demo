package com.example.demo.consistent;

import java.util.*;

/**
 * @author zg
 * @date 2019/2/11 16:07
 */
public class ConsistentHash<T> {
    private final HashFunction hashFunction;
    private final int numberOfReplicas;  // 虚拟节点
    private final SortedMap<Long, T> circle = new TreeMap<Long, T>();   // 用来存储虚拟节点hash值 到真实node的映射


    public ConsistentHash(HashFunction hashFunction, int numberOfReplicas, Collection<T> nodes) {
        this.hashFunction = hashFunction;
        this.numberOfReplicas = numberOfReplicas;
        for (T node : nodes) {
            add(node);
        }
    }

    public void add(T node) {
        for (int i = 1; i <= numberOfReplicas; i++) {
            circle.put(hashFunction.hash(node.toString() + i), node);
        }
    }

    public T get(Object key) {
        Long hash = hashFunction.hash(key.toString());
        if (!circle.containsKey(hash)) {
            SortedMap<Long, T> longTSortedMap = circle.tailMap(hash);
            hash = longTSortedMap.isEmpty() ? circle.firstKey() : longTSortedMap.firstKey();
        }
        return circle.get(hash);
    }

    public void remove(T node) {
        for (int i = 1; i <= numberOfReplicas; i++) {
            circle.remove(hashFunction.hash(node.toString() + 1));
        }
    }

    public long size() {
        return circle.size();
    }

    public void testBalance() {
        Set<Long> keys = circle.keySet();
        SortedSet<Long> sortedSet = new TreeSet<>(keys);
        for (Long key : sortedSet) {
            System.out.println(key);
        }

        System.out.println("----each location 's distance are follows: ----");

        Iterator<Long> i1 = sortedSet.iterator();
        Iterator<Long> i2 = sortedSet.iterator();
        if (i2.hasNext()) {
            i2.next();
        }
        long keyPre, keyAfter;
        while (i1.hasNext() && i2.hasNext()) {
            keyPre = i1.next();
            keyAfter = i2.next();
            System.out.println(keyAfter - keyPre);
        }
    }

    public static void main(String[] args) {
        Set<String> nodes = new HashSet<String>();
        nodes.add("A");
        nodes.add("B");
        nodes.add("C");

        ConsistentHash<String> consistentHash = new ConsistentHash<String>(new HashFunction(), 2, nodes);
//        consistentHash.add("D");

        System.out.println("hash circle size: " + consistentHash.size());
        System.out.println("location of each node are follows: ");
        consistentHash.testBalance();
    }
}
