package com.example.demo.sort;


/**
 * @author zg
 * @date 2019/1/19 16:15
 */
public class MergeSort {

    public static int[] arr = new int[]{23, 21, 34, 67, 123, 54, 78, 74, 102, 23, 89, 545};
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
        int mid = (start + end) / 2;
        mergeSortC(arr, start, mid);
        mergeSortC(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] tmp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
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
