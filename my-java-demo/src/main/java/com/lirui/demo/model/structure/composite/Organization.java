package com.lirui.demo.model.structure.composite;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 组合模式 -- 抽象构建
 * @author Ryan
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class Organization {

    private String name;

    private String desc;

    public void add(Organization org) {
        throw new UnsupportedOperationException();
    }

    public void remove(Organization org) {
        throw new UnsupportedOperationException();
    }

    protected abstract void print();
}
