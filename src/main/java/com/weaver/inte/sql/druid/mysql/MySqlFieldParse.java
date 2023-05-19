package com.weaver.inte.sql.druid.mysql;

import com.alibaba.druid.sql.ast.SQLExpr;
import com.alibaba.druid.sql.ast.expr.SQLPropertyExpr;
import com.alibaba.druid.sql.ast.statement.SQLSelectItem;
import com.alibaba.druid.sql.ast.statement.SQLSelectQueryBlock;
import com.weaver.inte.sql.druid.FieldParse;
import com.weaver.inte.sql.druid.entity.SqlParseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: saps.weaver
 * @create: 2023-05-19 11:10
 **/
public class MySqlFieldParse implements FieldParse {

    @Override
    public void parse(SQLSelectQueryBlock sqlSelectQueryBlock, SqlParseEntity sqlParseEntity) {
        List<SQLSelectItem> sqlSelectItemList = sqlSelectQueryBlock.getSelectList();

        List<String> fieldNameList = new ArrayList<>();
        for (SQLSelectItem item : sqlSelectItemList) {
            SQLExpr sqlExpr = item.getExpr();
            if (sqlExpr instanceof SQLPropertyExpr) {
                fieldNameList.add(((SQLPropertyExpr) sqlExpr).getName());
            } else {
                fieldNameList.add(item.getAlias());
            }
        }
        sqlParseEntity.setFieldEntity(fieldNameList);
    }
}
