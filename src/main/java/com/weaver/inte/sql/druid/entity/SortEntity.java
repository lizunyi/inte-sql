package com.weaver.inte.sql.druid.entity;

import java.io.Serializable;

/**
 * @author: saps.weaver
 * @create: 2023-05-19 11:16
 **/
public class SortEntity implements Serializable {

    private static final long serialVersionUID = 1935004322622458630L;

    private String sort;

    // 0.asc,1.desc
    private String type;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
