package com.example.demo.sort;

/**
 * 插入排序
 *
 * @author zg
 * @date 2019/1/30
 */
public class InsertSort {
    public static int[] arr = new int[]{231, 100, 134, 123, 54, 78, 74, 102, 23, 89, 128};

    public static void main(String[] args) {
        insertSort(arr, arr.length);
        for (int i : arr) {
            System.out.print(i + "=>");
        }
    }

//    private static void insertSort(int[] arr, int length) {
//        for (int i=1;i<length;i++) {
//            int value = arr[i];
//            int j = i-1;
//            for (;j>=0;j--) {
//                if (value < arr[j]) {
//                    arr[j+1] = arr[j];
//                } else {
//                    break;
//                }
//            }
//            arr[j+1] = value;
//        }
//    }

//    /**
//     * 20190131
//     * @param arr
//     * @param length
//     */
//    private static void insertSort(int[] arr, int length) {
//        for (int i=1; i<length; i++) {
//            int value = arr[i];
//            int j = i-1;
//            for (;j>=0;j--) {
//                if (arr[j] > value) {
//                    arr[j+1] = arr[j];
//                } else {
//                    break;
//                }
//            }
//            arr[j+1] = value;
//        }
//    }


    /**
     * 20190201
     *
     * @param arr
     * @param length
     */
//    private static void insertSort(int[] arr, int length) {
//        for (int i = 1; i < length; i++) {
//            int value = arr[i];
//            int j = i - 1;
//            for (; j >= 0; j--) {
//                if (arr[j] > value) {
//                    arr[j+1] = arr[j];
//                } else {
//                    break;
//                }
//            }
//            arr[j+1] = value;
//        }
//    }


    /**
     * 20190201
     *
     * @param arr
     * @param length
     */
//    private static void insertSort(int[] arr, int length) {
//        for (int i = 1; i < length; i++) {
//            int j = i - 1;
//            int value = arr[i];
//            for (; j >= 0; j--) {
//                if (arr[j] > value) {
//                    arr[j + 1] = arr[j];
//                } else {
//                    break;
//                }
//            }
//            arr[j + 1] = value;
//        }
//    }


    /**
     * 20190206
     *
     * @param arr
     * @param length
     */
    private static void insertSort(int[] arr, int length) {

        for (int i = 1; i < length; i++) {
            int j = i - 1;
            int value = arr[i];
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j+1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j+1] = value;
        }


    }


}
