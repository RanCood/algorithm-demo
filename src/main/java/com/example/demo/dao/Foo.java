package com.example.demo.dao;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zg
 * @date 2019/2/15 14:27
 */
@Data
public class Foo implements Serializable {
    private static final long serialVersionUID = -3309946762006237372L;
    private Long id;
    private String name;
}
