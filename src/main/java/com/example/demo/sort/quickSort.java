package com.example.demo.sort;


/**
 * @author zg
 * @date 2019/1/19 18:07
 */
public class quickSort {
    public static int[] arr = new int[]{231, 100, 223, 123, 54, 78, 74, 102, 23, 89, 545};
    public static int[] ar1 = new int[]{231, 100, 223, 123, 54, 78, 74, 102, 23, 89, 545};

    public static void main(String[] args) {
        quickSort(arr, arr.length);
        for (int i : arr) {
            System.out.print(i + "=>");
        }
        System.out.println("");
        quickSort1(ar1, ar1.length, 8);
    }

    public static void quickSort1(int[] arr, int n, int k) {
        quickSortC1(arr, 0, n - 1, k);
    }

    private static void quickSortC1(int[] arr, int s, int e, int k) {
        if (s >= e) {
            return;
        }
        int n = partition1(arr, s, e);
        if (n + 1 == k) {
            System.out.println(arr[n]);
            return;
        } else if (n + 1 > k) {
            quickSortC1(arr, s, n - 1, k);
        } else if (n + 1 < k) {
            quickSortC1(arr, n + 1, e, k);
        }

    }

    private static int partition1(int[] arr, int s, int e) {
        int value = arr[e];
        int i = s, j = s;
        for (; j <= e; ++j) {
            if (arr[j] < value) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                ++i;
            }
        }
        arr[e] = arr[i];
        arr[i] = value;
        return i;
    }

    public static void quickSort(int[] arr, int length) {
        quickSortC(arr, 0, length - 1);
    }

    private static void quickSortC(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int p = partition(arr, start, end);
        quickSortC(arr, start, p - 1);
        quickSortC(arr, p + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int value = arr[end];
        int i = start, j = start;
        for (; j < end; j++) {
            if (arr[j] < value) {
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
                i++;
            }
        }
        arr[end] = arr[i];
        arr[i] = value;
        return i;
    }

}
