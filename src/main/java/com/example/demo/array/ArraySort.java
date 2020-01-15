package com.example.demo.array;

/**
 * 数组排序
 * 1冒泡排序
 * 2插入排序
 * 3选择排序
 *
 * @author zg
 * @date 2018/11/13 13:32
 */
public class ArraySort {
    public static int[] arr = {23, 54, 13, 45, 32, 23, 89, 19};

    public static void main(String[] args) {
//        bubbleSort(arr, arr.length);
//        insertSort(arr);
        selectSort(arr, 0, arr.length - 1,6);
        printArr(arr);
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr, int length) {
        for (int i = 0; i < length; i++) {
            boolean flag = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = true;
                }
            }
            if (!flag) {
                break;
            }
        }
        printArr(arr);
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; --j) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = value;
        }
        printArr(arr);
    }

    public static void selectSort(int[] arr, int q, int r,int k) {
        if (q >= r) {
            return;
        }

        int p = partion(arr, q, r);
        if(p+1 == k) {
            System.out.println(arr[p]);
        }
        selectSort(arr, q, p - 1,k);
        selectSort(arr, p + 1, r,k);
    }

    public static int partion(int[] arr, int q, int r) {
        int value = arr[r];
        int i = q;
        int j = q;
        for (; j < r; j++) {
            if (arr[j] < value) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
            }
        }
        arr[r] = arr[i];
        arr[i] = value;
        return i;
    }


    public static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + "->");
        }
        System.out.println();
    }

}
