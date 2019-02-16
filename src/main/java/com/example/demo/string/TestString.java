package com.example.demo.string;

/**
 * @author zg
 * @date 2019/1/31
 */
public class TestString {
    public static void main(String[] args) {
        String s1 = "zg";
        String s2 = "zyj";
        String s3 = new String("zg");
        String intern = s3.intern();
        String s4 = new String("zg").intern();
        System.out.println(s1 == s4);
        System.out.println(s1 == s3);

    }
}
