package com.zg.design.expression;

import java.util.Map;

/**
 * @author: zg
 * @date: 2022/3/9 16:30
 */
public class BooleanExpression implements Expression {
    private Boolean value;

    public BooleanExpression(String strExpression) {
        String element = strExpression.trim();
        value = Boolean.valueOf(strExpression.trim());
        if (element.equals("true") || element.equals("false")) {
            value = Boolean.valueOf(strExpression.trim());
        } else {
            throw new RuntimeException("Expression is invalid: " + strExpression);
        }
    }

    public BooleanExpression(Boolean value) {
        this.value = value;
    }

    @Override
    public boolean interpret(Map<String, Long> stats) {
        return value;
    }
}
