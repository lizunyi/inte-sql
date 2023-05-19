package com.weaver.inte.sql.druid.core;

import com.alibaba.druid.sql.ast.statement.SQLSelectQueryBlock;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlSelectQueryBlock;
import com.alibaba.druid.sql.dialect.mysql.parser.MySqlStatementParser;
import com.alibaba.druid.sql.parser.SQLStatementParser;
import com.alibaba.druid.util.JdbcUtils;
import com.weaver.inte.sql.druid.entity.SqlParseEntity;
import com.weaver.inte.sql.druid.mysql.MySqlFieldParse;
import com.weaver.inte.sql.druid.mysql.MySqlGroupParse;
import com.weaver.inte.sql.druid.mysql.MySqlPageParse;
import com.weaver.inte.sql.druid.mysql.MySqlSortParse;

/**
 * @author: saps.weaver
 * @create: 2023-05-19 11:26
 **/
public class SqlParseCore {
    public static SqlParseEntity buildQuery(String sql, String dbType) {
        SQLStatementParser exprParser = null;
        if (dbType.equalsIgnoreCase(JdbcUtils.MYSQL)) {
            exprParser = new MySqlStatementParser(sql);
        }
        SQLSelectQueryBlock selectQueryBlock = (SQLSelectQueryBlock) exprParser.parseSelect().getSelect().getQuery();

        SqlParseEntity sqlParseEntity = new SqlParseEntity();
        sqlParseEntity.setDbType(dbType);

        if (dbType.equalsIgnoreCase(JdbcUtils.MYSQL)) {
            new MySqlFieldParse().parse(selectQueryBlock, sqlParseEntity);
            new MySqlGroupParse().parse(selectQueryBlock, sqlParseEntity);
            new MySqlPageParse().parse((MySqlSelectQueryBlock) selectQueryBlock, sqlParseEntity);
            new MySqlSortParse().parse((MySqlSelectQueryBlock) selectQueryBlock, sqlParseEntity);
        }
        return sqlParseEntity;
    }
}
