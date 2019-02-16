package com.example.demo.sort;

/**
 * 计数排序
 *
 * @author zg
 * @date 2019/1/23 10:39
 */
public class CountSort {
    public static int[] arr = new int[]{0, 2, 2, 3, 4, 4, 10, 10, 10, 2, 1, 4};

    public static void main(String[] args) {
        countSort(arr, arr.length);
        for (int i : arr) {
            System.out.print(i + "=>");
        }
    }

    public static void countSort(int[] arr, int length) {
        int max = 0;
        int min = 0;
        for (int i = 0; i < length; i++) {
            max = Math.max(arr[i], max);
            min = Math.min(arr[i], min);
        }

        int[] c = new int[max + 1];

        for (int i = 0; i <= max; i++) {
            c[i] = 0;
        }

        for (int i = 0; i < length; i++) {
            c[arr[i]]++;
        }

        for (int i = 1; i <= max; i++) {
            c[i] = c[i - 1] + c[i];
        }

        int[] r = new int[length];

        for (int i = 0; i < length; i++) {
            int index = c[arr[i]] - 1;
            r[index] = arr[i];
            c[arr[i]]--;
        }

        for (int i = 0; i < length; i++) {
            arr[i] = r[i];
        }

    }
}
