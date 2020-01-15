package com.example.demo.sort;

/**
 * @author zg
 * @date 2019/7/9 13:49
 */
public class EfSearch {
    public static int[] arr = new int[]{1, 2, 2, 2, 2, 2, 3, 4, 4, 10, 20, 30, 32, 41, 44};

    public static void main(String[] args) {
        System.out.println(ersearch(arr, 0, arr.length - 1, 2));
        System.out.println(ersearch1(arr, 0, arr.length - 1, 2));
        System.out.println(ersearch2(arr, 0, arr.length - 1, 2));
    }

    /**
     * 最基础
     *
     * @param arr
     * @param start
     * @param end
     * @param value
     * @return
     */
    public static int ersearch(int[] arr, int start, int end, int value) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > value) {
                end = mid - 1;
            } else if (arr[mid] < value) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 第一个大于等于value的
     *
     * @param arr
     * @param start
     * @param end
     * @param value
     * @return
     */
    public static int ersearch1(int[] arr, int start, int end, int value) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > value) {
                end = mid - 1;
            } else if (arr[mid] < value) {
                start = mid + 1;
            } else {
                if (mid != 0 && arr[mid - 1] == value) {
                    end = mid - 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }

    /**
     * 最后一个小于等于value的
     *
     * @param arr
     * @param start
     * @param end
     * @param value
     * @return
     */
    public static int ersearch2(int[] arr, int start, int end, int value) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] > value) {
                end = mid - 1;
            } else if (arr[mid] < value) {
                start = mid + 1;
            } else {
                if (mid != 0 && arr[mid + 1] == value) {
                    start = mid + 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }
}
