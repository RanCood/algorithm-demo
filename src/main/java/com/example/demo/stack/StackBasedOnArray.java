package com.example.demo.stack;

/**
 * @author zg
 * @date 2018/11/10
 */
public class StackBasedOnArray {

    public static void main(String[] args) {
        StackBasedOnArray stack = new StackBasedOnArray(10);
        stack.push(3);
        stack.push(14);
        stack.push(8);
        stack.push(54);
        stack.push(13);
        stack.printAll();
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    private Array array = null;
    private int top = 0;

    public StackBasedOnArray(int length) {
        array = new Array(length);
    }

    public void push(int value) {
        if (top >= array.length) {
            System.out.println("超出范围");
            return;
        }
        array.insert(top, value);
        ++top;
    }

    public int pop() {
        if (top == 0) {
            return -1;
        } else {
            --top;
            return array.deleteTail();
        }
    }

    public void printAll(){
        for (int i=0; i<array.count;i++){
            System.out.print(this.array.data[i]+"->");
        }
        System.out.println("结束");
    }
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

        public int deleteTail(){
            if (count == 0) {
                return -1;
            }
            return this.data[--count];
        }
        public Boolean delete(int index) {
            if (index < 0 || index > this.length) {
                return false;
            }
            for (int i = index + 1; i < this.count; i++) {
                this.data[i - 1] = this.data[i];
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
}
