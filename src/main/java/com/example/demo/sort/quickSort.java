package com.example.demo.sort;

/**
 * @author zg
 * @date 2019/1/19 18:07
 */
public class quickSort {
    public static int[] arr = new int[]{231, 100, 223, 123, 54, 78, 74, 102, 23, 89, 545};

    public static void main(String[] args) {
        quickSort(arr, arr.length);
        for (int i : arr) {
            System.out.print(i + "=>");
        }
    }

    public static void quickSort(int[] arr, int length) {
        quickSortC(arr, 0, length - 1);
    }

    private static void quickSortC(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int q = partition(arr, start, end);
        quickSortC(arr, start, q - 1);
        quickSortC(arr, q + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start;
        for (int j=start;j<end;j++) {
            if (arr[j] < pivot) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
            }
        }
        arr[end] = arr[i];
        arr[i] = pivot;
        return i;
    }
}