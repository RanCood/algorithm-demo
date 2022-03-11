package com.zg.expression;

import java.util.Map;
import java.util.Stack;

/**
 * @author: zg
 * @date: 2022/3/10 16:07
 */
public class BracketsExpression implements Expression {

    private String ruleExpression;

    public BracketsExpression(String expressionStr) {
        this.ruleExpression = expressionStr;
    }

    @Override
    public boolean interpret(Map<String, Long> stats) {
        if (!ruleExpression.contains("(")) {
            return new OrExpression(ruleExpression).interpret(stats);
        }
        Stack<Integer> stack = new Stack();
        char[] chars = ruleExpression.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                Integer start = stack.pop();
                if (start == null) {
                    throw new RuntimeException("表达式不正确");
                }
                String expr = ruleExpression.substring(start + 1, i);
                boolean interpret = new OrExpression(expr).interpret(stats);
                ruleExpression = new StringBuilder(ruleExpression.substring(0, start))
                        .append(interpret)
                        .append(ruleExpression.substring(i + 1)).toString();
                break;
            }
            if(!stack.isEmpty() && i == chars.length) {
                throw new RuntimeException("表达式不正确");
            }
        }

        if (ruleExpression.contains("(")) {
            return interpret(stats);
        } else {
            return new OrExpression(ruleExpression).interpret(stats);
        }
    }

}
