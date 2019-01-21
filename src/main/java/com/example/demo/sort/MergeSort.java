package com.example.demo.sort;

/**
 * @author zg
 * @date 2019/1/19 16:15
 */
public class MergeSort {

    public static int[] arr = new int[]{23, 21, 34, 67, 843, 231, 100, 223, 123, 54, 78, 74, 102, 23, 89, 545};
    //, 100, 223, 123, 54, 78, 74, 102, 23, 89, 545

    public static void main(String[] args) {
        mergeSort(arr, arr.length);
        for (int i : arr) {
            System.out.print(i + "=>");
        }
    }

    public static void mergeSort(int[] arr, int length) {
        mergeSortC(arr, 0, length - 1);
    }

    private static void mergeSortC(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int intermediate = (start + end) / 2;
        mergeSortC(arr, start, intermediate);
        mergeSortC(arr, intermediate + 1, end);
        merge(arr, start, intermediate, end);
    }

    private static void merge(int[] arr, int start, int intermediate, int end) {
        int[] tmp = new int[end - start + 1];
        int i = start, j = intermediate + 1, k = 0;
        while (i <= intermediate && j <= end) {
            if (arr[i] >= arr[j]) {
                tmp[k++] = arr[j++];
            } else {
                tmp[k++] = arr[i++];
            }
        }

        while (i <= intermediate) {
            tmp[k++] = arr[i++];
        }
        while (j <= end) {
            tmp[k++] = arr[j++];
        }

        for (int n = 0; n < tmp.length; n++) {
            arr[start++] = tmp[n];
        }
    }
}
