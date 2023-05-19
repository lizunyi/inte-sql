package com.weaver.inte.sql.druid.entity;

import java.io.Serializable;

/**
 * @author: saps.weaver
 * @create: 2023-05-19 11:16
 **/
public class PageEntity implements Serializable {

    private static final long serialVersionUID = -3968942444402663458L;

    private Integer offset;
    private Integer limit;

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}
