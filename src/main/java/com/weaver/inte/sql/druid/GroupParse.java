package com.weaver.inte.sql.druid;

import com.alibaba.druid.sql.ast.statement.SQLSelectQueryBlock;
import com.weaver.inte.sql.druid.entity.SqlParseEntity;

/**
 * @author: saps.weaver
 * @create: 2023-05-19 11:11
 **/
public interface GroupParse<T extends SQLSelectQueryBlock> {
    void parse(T sqlSelectQueryBlock, SqlParseEntity sqlParseEntity);
}
