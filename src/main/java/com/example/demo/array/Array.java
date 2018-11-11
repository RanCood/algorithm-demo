package com.example.demo.array;

/**
 * @author zg
 * @date 2018/11/10
 */
public class Array {
    private int[] data;
    //数组长度
    private int length;
    // 实际个数
    private int count;

    public Array() {

    }

    public Array(int length) {
        this.length = length;
        this.data = new int[length];
        this.count = 0;
    }

    public Boolean insert(int index, int value) {
        if (count == length) {
            System.out.println("data full");
            return false;
        }
        if (index < 0 || index > length) {
            System.out.println("位置不合法");
            return false;
        }

        this.data[index] = value;
        ++count;
        return true;
    }

    public Boolean delete(int index) {
        if (index < 0 || index > this.length) {
            return false;
        }
        for (int i = index + 1; i < this.count; i++) {
            this.data[i-1] = this.data[i];
        }
        --count;
        return true;
    }

    public int find(int index) {
        if (index < 0 || index > length) {
            return -1;
        }
        return this.data[index];
    }
}
