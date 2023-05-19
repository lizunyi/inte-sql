package com.weaver.inte.sql.druid.mysql;

import com.alibaba.druid.sql.ast.SQLOrderBy;
import com.alibaba.druid.sql.ast.statement.SQLSelectOrderByItem;
import com.alibaba.druid.sql.ast.statement.SQLSelectQueryBlock;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlSelectQueryBlock;
import com.weaver.inte.sql.druid.PageParse;
import com.weaver.inte.sql.druid.SortParse;
import com.weaver.inte.sql.druid.entity.PageEntity;
import com.weaver.inte.sql.druid.entity.SqlParseEntity;

import java.util.List;
import java.util.Optional;

/**
 * @author: saps.weaver
 * @create: 2023-05-19 11:11
 **/
public class MySqlPageParse implements PageParse<MySqlSelectQueryBlock> {

    @Override
    public void parse(MySqlSelectQueryBlock sqlSelectQueryBlock, SqlParseEntity sqlParseEntity) {
        MySqlSelectQueryBlock.Limit limit = sqlSelectQueryBlock.getLimit();
        if (limit != null) {
            PageEntity pageEntity = new PageEntity();
            pageEntity.setOffset(Optional.ofNullable(limit.getOffset()).map(x -> Integer.parseInt(x.toString())).orElse(null));
            pageEntity.setLimit(Optional.ofNullable(limit.getRowCount()).map(x -> Integer.parseInt(x.toString())).orElse(null));
            sqlParseEntity.setPageEntity(pageEntity);
        }
    }
}
