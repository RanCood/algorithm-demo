package com.example.demo.stream;

import java.io.Serializable;

/**
 * @author zg
 * @date 2018/12/10 20:08
 */
public class RiskType implements Serializable {
    private static final long serialVersionUID = -4411681293024792867L;

    public RiskType(String name) {
        this.name = name;
    }

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
