package com.example.demo.heap;

import reactor.core.Disposable;

import java.util.Arrays;

/**
 * @author: zg
 * @date: 2019/12/17 10:19
 */
public class Heap {
    private int[] a;
    private int count;
    private int n;

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    public void insert(int data) {
        if (count == n) {
            return;
        }
        ++count;
        a[count] = data;
        int i = count;
        while (i / 2 > 0 && a[i] > a[i / 2]) {
            swap(i, i / 2);
            i = i / 2;
        }
    }

    private void swap(int i, int n) {
        int temp = a[i];
        a[i] = a[n];
        a[n] = temp;
    }

    public void removeMax() {
        if (count == 0) {
            return;
        }
        a[1] = a[count];
        a[count] = 0;
        --count;
        heapify();
    }

    private void heapify() {
        if (count == 0) {
            return;
        }
        int i = 1;
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] < a[2 * i]) {
                maxPos = 2 * i;
            }
            if (i * 2 + 1 <= n && a[maxPos] < a[2 * i + 1]) {
                maxPos = 2 * i + 1;
            }
            if (maxPos == i) {
                break;
            }
            swap(i, maxPos);
            i = maxPos;
        }
    }

    public void printHeap() {
        Arrays.stream(a).forEach(i -> {
            System.out.print(i + "-->");
        });
    }

}
