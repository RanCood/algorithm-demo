package com.example.demo.stack;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author zg
 * @date 2019/7/2 17:43
 */
public class Calculation {
    public static void main(String[] args) {
//        List<> numebrList = new ArrayList<>();
//        StackBasedOnArray stack = new StackBasedOnArray(64);
//        String str = "3-22*54+82-42";
//        char[] chars = str.toCharArray();
//        for (char c: chars) {
//
//            System.out.println(c);
//        }
        String str = "[{fdfdf(dfdf[1 -2]d)fdfdf}]";
        String str1 = "A&B|C&D|E|F";
        System.out.println(analysis(str));
    }
    public static boolean analysis(String expression){
        StackBasedOnArray stack = new StackBasedOnArray(10);
        char[] chars = expression.toCharArray();
        for (char c: chars) {
//            System.out.println(c+"="+(int)c);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            }
            if (c == '}') {
                int pop = stack.pop();
                if('{' != (char)pop){
                    return false;
                }
            } else if(c == ']' ) {
                int pop = stack.pop();
                if('[' != (char)pop){
                    return false;
                }
            }else if(c == ')' ) {
                int pop = stack.pop();
                if('(' != (char)pop){
                    return false;
                }
            }
        }
        if (stack.pop() != -1){
            return false;
        }
        return true;
    }
}
