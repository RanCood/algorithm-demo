package com.example.demo.sort;

/**
 * @author zg
 * @date 2019/1/23 11:20
 */
public class InsertSort {
    public static int[] arr = new int[]{231, 100, 223, 123, 54, 78, 74, 102, 23, 89, 545};

    public static void main(String[] args) {
        insertSort(arr, arr.length);
        for (int i : arr) {
            System.out.print(i + "=>");
        }
    }

    public static void insertSort(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j+1] = value;
        }
    }
}
