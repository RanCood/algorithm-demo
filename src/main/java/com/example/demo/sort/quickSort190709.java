package com.example.demo.sort;


/**
 * @author zg
 * @date 2019/1/19 18:07
 */
public class quickSort190709 {
    public static int[] arr = new int[]{231, 100, 223, 123, 54, 78, 74, 102, 23, 89, 545};

    public static void main(String[] args) {
        quickSort(arr, arr.length);
        for (int i : arr) {
            System.out.print(i + "=>");
        }
        System.out.println("");
//        quickSort1(ar1, ar1.length, 8);
    }


    public static void quickSort(int[] arr, int length) {
        quickSortC(arr, 0, length - 1);
    }

    private static void quickSortC(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int partition = partition(arr, start, end);
        quickSortC(arr, start, partition - 1);
        quickSortC(arr, partition + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int value = arr[end];
        int i = start, j = start;
        for (; j < end; ++j) {
            if (arr[j] < value) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                ++i;
            }
        }
        arr[end] = arr[i];
        arr[i] = value;
        return i;
    }

}
