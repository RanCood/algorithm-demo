package com.example.demo.heap;

import java.util.Arrays;

/**
 * @author: zg
 * @date: 2019/12/17 09:51
 */
public class Test1 {

    public static final int[] arr = {0, 31, 35, 23, 87, 32, 34, 37, 36};

    public static void main(String[] args) {
        Heap heap = new Heap(20);
        heap.insert(43);
        heap.insert(41);
        heap.insert(42);
        heap.insert(53);
        heap.insert(54);
        heap.insert(55);
        heap.insert(56);
        heap.insert(67);
        heap.insert(59);

        heap.printHeap();
        heap.removeMax();
        System.out.println("------------");
        heap.printHeap();

//        buildHeap(arr, arr.length - 1);
    }

    private static void buildHeap(int[] arr, int n) {
        for (int i = n / 2; i > 0; i--) {
            heapify(arr, n, i);
        }
        printHeap(arr);
    }

    public static void printHeap(int[] arr) {
        Arrays.stream(arr).forEach(i -> {
            System.out.print(i + "-->");
        });
    }

    private static void heapify(int[] arr, int n, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && arr[i] < arr[2 * i]) {
                maxPos = 2 * i;
            }
            if (i * 2 + 1 <= n && arr[maxPos] < arr[2 * i + 1]) {
                maxPos = 2 * i + 1;
            }
            if (maxPos == i) {
                break;
            }
            swap(arr, i, maxPos);
            i = maxPos;
        }
    }

    private static void swap(int[] arr, int i, int maxPos) {
        int n = arr[i];
        arr[i] = arr[maxPos];
        arr[maxPos] = n;
    }

    private static void removeTop(int[] arr) {
    }


}
