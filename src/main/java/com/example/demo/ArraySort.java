package com.example.demo;

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
//        bubbleSort(arr);
//        insertSort(arr);
    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        printArr(arr);
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > value){
                    arr[j+1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j+1] = value;
        }
        printArr(arr);
    }


    public static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + "->");
        }
        System.out.println();
    }

}
