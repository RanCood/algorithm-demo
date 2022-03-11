package com.zg.design.expression;

import java.util.Map;

/**
 * 解释器
 *
 * @author: zg
 * @date: 2022/3/9 16:29
 */
public interface Expression {
    boolean interpret(Map<String, Long> stats);
}
