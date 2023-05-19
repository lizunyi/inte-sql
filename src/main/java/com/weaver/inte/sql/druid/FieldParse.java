package com.weaver.inte.sql.druid;

import com.alibaba.druid.sql.ast.statement.SQLSelectQuery;
import com.alibaba.druid.sql.ast.statement.SQLSelectQueryBlock;
import com.weaver.inte.sql.druid.entity.SqlParseEntity;

/**
 * @author: saps.weaver
 * @create: 2023-05-19 11:10
 **/
public interface FieldParse<T extends SQLSelectQueryBlock> {
    void parse(T sqlSelectQueryBlock, SqlParseEntity sqlParseEntity);
}
