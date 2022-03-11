package com.zg.design.expression;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author: zg
 * @date: 2022/3/9 19:55
 */
public class Calculator {

    public static void main(String[] args) {
        String expression = "1 + 3 * 10 / 2 + 20 - 10";
        calculator(expression);
    }

    public static void calculator(String expressionStr) {
        Stack<Long> numStack = new Stack();
        Stack<String> operStack = new Stack();
        List<String> elementList = new ArrayList<>();
        String[] elements = expressionStr.trim().split("\\s+");
        for (String element : elements) {
            elementList.add(element);
        }

        for (int i = 0; i < elementList.size(); i++) {
            String element = elementList.get(i);
            if (element.equals("+") || element.equals("-") || element.equals("*") || element.equals("/")) {
                if (!operStack.isEmpty() && !priority(operStack.peek(), element)) {
                    //计算
                    cal(numStack, operStack);
                }
                operStack.add(String.valueOf(element));
            } else if (NumberUtils.isDigits(element)) {
                //数字
                numStack.add(Long.valueOf(element));
            } else if ("(".equals(element)) {
                operStack.add(String.valueOf(element));
            } else if (")".equals(element)) {
                while (!operStack.peek().equals("(")) {
                    cal(numStack, operStack);
                }
                operStack.pop();
            }
        }
        while (!operStack.isEmpty()) {
            cal(numStack, operStack);
        }
        System.out.println(numStack.pop());
    }

    private static boolean priority(String a, String c) {
        String opers = "+- */";
        if(opers.contains(a) && opers.contains(c)) {
            return (opers.indexOf(c) - opers.indexOf(a)) > 1;
        }
        return true;
    }

    private static void cal(Stack<Long> numStack, Stack<String> operStack) {
        Long num1 = numStack.pop();
        Long num2 = numStack.pop();
        String oper = operStack.pop();
        if (oper.equals("+")) {
            numStack.push(num2 + num1);
        } else if (oper.equals("-")) {
            numStack.push(num2 - num1);
        } else if (oper.equals("*")) {
            numStack.push(num2 * num1);
        } else if (oper.equals("/")) {
            numStack.push(num2 / num1);
        } else {
            throw new RuntimeException("Expression is invalid");
        }
    }
}
