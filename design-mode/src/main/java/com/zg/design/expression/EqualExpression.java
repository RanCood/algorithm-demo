package com.zg.design.expression;

import java.util.Map;

/**
 * @author: zg
 * @date: 2022/3/9 16:30
 */
public class EqualExpression implements Expression {
    private String key;
    private Long value;

    public EqualExpression(String strExpression) {
        String[] elements = strExpression.trim().split("\\s+");
        if (elements.length != 3 || !elements[1].equals("==")) {
            throw new RuntimeException("Expression is invalid: " + strExpression);
        }
        this.key = elements[0];
        this.value = Long.valueOf(elements[2]);
    }

    public EqualExpression(String key, Long value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public boolean interpret(Map<String, Long> stats) {
        if (!stats.containsKey(this.key)) {
            return false;
        }
        Long statValue = stats.get(this.key);
        return statValue.equals(value) ;
    }
}
