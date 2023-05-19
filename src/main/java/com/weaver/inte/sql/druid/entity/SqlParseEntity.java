package com.weaver.inte.sql.druid.entity;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
import java.util.List;

/**
 * @author: saps.weaver
 * @create: 2023-05-19 11:15
 **/
public class SqlParseEntity implements Serializable {

    private static final long serialVersionUID = 7028613525807256085L;

    private String dbType;

    //查询字段集合
    private List<String> fieldEntity;
    //排序集合
    private List<SortEntity> sortEntity;
    //分组集合
    private List<String> groupEntity;
    //分页信息
    private PageEntity pageEntity;

    public String getDbType() {
        return dbType;
    }

    public void setDbType(String dbType) {
        this.dbType = dbType;
    }

    public List<String> getFieldEntity() {
        return fieldEntity;
    }

    public void setFieldEntity(List<String> fieldEntity) {
        this.fieldEntity = fieldEntity;
    }

    public List<SortEntity> getSortEntity() {
        return sortEntity;
    }

    public void setSortEntity(List<SortEntity> sortEntity) {
        this.sortEntity = sortEntity;
    }

    public List<String> getGroupEntity() {
        return groupEntity;
    }

    public void setGroupEntity(List<String> groupEntity) {
        this.groupEntity = groupEntity;
    }

    public PageEntity getPageEntity() {
        return pageEntity;
    }

    public void setPageEntity(PageEntity pageEntity) {
        this.pageEntity = pageEntity;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
