package com.zg.design.expression;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zg
 * @date: 2022/3/9 16:48
 */
public class AlertRuleInterpreter {
    private Expression expression;

    public AlertRuleInterpreter(String ruleExpression) {
        this.expression = new BracketsExpression(ruleExpression);
    }

    public boolean interpret(Map<String, Long> stats) {
        return expression.interpret(stats);
    }

    public static void main(String[] args) {
        String rule = "k1 > 100 && ( ( k5 > 50 && ( k2 < 50 || k3 == 100 ) ) && k6 == 100 ) && k4 > 50";
        // k1 > 100 && ( ( k5 > 50 && boolean ) && k6 == 100 ) && k4 > 50
        // k1 > 100 && ( boolean && k6 == 100 ) && k4 > 50
        // k1 > 100 && boolean && k4 > 50
//        String rule = "key1 > 100 &&  key2 < 30 || key3 < 100 || key4 == 88 ";
        AlertRuleInterpreter interpreter = new AlertRuleInterpreter(rule);
        Map<String, Long> stats = new HashMap<>();
        stats.put("k1", 101L);
        stats.put("k2", 22L);
        stats.put("k3", 121L);
        stats.put("k4", 44L);
        stats.put("k5", 51L);
        stats.put("k6", 100L);
        boolean alert = interpreter.interpret(stats);
        System.out.println(alert);
    }
}
