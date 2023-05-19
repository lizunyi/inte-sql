package com.weaver.inte.sql.druid.mysql;

import com.alibaba.druid.sql.ast.SQLOrderBy;
import com.alibaba.druid.sql.ast.statement.SQLSelectOrderByItem;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlSelectQueryBlock;
import com.alibaba.druid.util.StringUtils;
import com.weaver.inte.sql.druid.SortParse;
import com.weaver.inte.sql.druid.entity.SortEntity;
import com.weaver.inte.sql.druid.entity.SqlParseEntity;
import com.weaver.inte.utils.StringExtUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author: saps.weaver
 * @create: 2023-05-19 11:11
 **/
public class MySqlSortParse implements SortParse<MySqlSelectQueryBlock> {

    @Override
    public void parse(MySqlSelectQueryBlock sqlSelectQueryBlock, SqlParseEntity sqlParseEntity) {
        SQLOrderBy sqlOrderBy = sqlSelectQueryBlock.getOrderBy();

        List<SortEntity> sortEntityList = new ArrayList<>();
        if (sqlOrderBy != null) {
            List<SQLSelectOrderByItem> orderByItemList = sqlOrderBy.getItems();
            for (SQLSelectOrderByItem item : orderByItemList) {
                SortEntity sortEntity = new SortEntity();
                sortEntity.setSort(item.getExpr().toString());
                sortEntity.setType(Optional.ofNullable(item.getType()).map(x -> x.name().toLowerCase()).orElse("asc"));
                sortEntityList.add(sortEntity);
            }
        }
        sqlParseEntity.setSortEntity(sortEntityList);
    }
}
