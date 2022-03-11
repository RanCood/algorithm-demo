package com.zg.design.expression;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: zg
 * @date: 2022/3/9 16:30
 */
public class AndExpression implements Expression {
    List<Expression> expressions = new ArrayList();

    public AndExpression(String strExpression) {
        String[] elements = strExpression.trim().split("&&");
        for (String strAndExpression : elements) {
            if (strAndExpression.contains("<")) {
                expressions.add(new LessExpression(strAndExpression));
            } else if (strAndExpression.contains(">")) {
                expressions.add(new GreaterExpression(strAndExpression));
            } else if (strAndExpression.contains("==")) {
                expressions.add(new EqualExpression(strAndExpression));
            } else if (strAndExpression.trim().contains("true") || strAndExpression.trim().contains("false")) {
                expressions.add(new BooleanExpression(strAndExpression));
            } else {
                throw new RuntimeException("Expression is invalid: " + strAndExpression);
            }
        }
    }

    public AndExpression(List<Expression> expressions) {
        expressions.addAll(expressions);
    }

    @Override
    public boolean interpret(Map<String, Long> stats) {
        for (Expression expression : expressions) {
            if (!expression.interpret(stats)) {
                return false;
            }
        }
        return true;
    }
}
