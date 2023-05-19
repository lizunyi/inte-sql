package com.weaver.inte.sql.druid.mysql;

import com.alibaba.druid.sql.ast.SQLExpr;
import com.alibaba.druid.sql.ast.statement.SQLSelectGroupByClause;
import com.alibaba.druid.sql.ast.statement.SQLSelectQueryBlock;
import com.weaver.inte.sql.druid.GroupParse;
import com.weaver.inte.sql.druid.entity.SqlParseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: saps.weaver
 * @create: 2023-05-19 11:11
 **/
public class MySqlGroupParse implements GroupParse {

    @Override
    public void parse(SQLSelectQueryBlock sqlSelectQueryBlock, SqlParseEntity sqlParseEntity) {
        SQLSelectGroupByClause sqlSelectGroupByClause = sqlSelectQueryBlock.getGroupBy();

        List<String> groupEntityList = new ArrayList<>();
        if (sqlSelectGroupByClause != null) {
            List<SQLExpr> groupList = sqlSelectGroupByClause.getItems();
            for (SQLExpr sqlExpr : groupList) {
                groupEntityList.add(sqlExpr.toString());
            }
        }
        sqlParseEntity.setGroupEntity(groupEntityList);
    }
}
