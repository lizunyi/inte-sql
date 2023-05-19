package com.weaver.inte.sql;

import com.alibaba.druid.sql.ast.SQLExpr;
import com.alibaba.druid.sql.ast.SQLOrderBy;
import com.alibaba.druid.sql.ast.expr.SQLPropertyExpr;
import com.alibaba.druid.sql.ast.statement.SQLSelectGroupByClause;
import com.alibaba.druid.sql.ast.statement.SQLSelectItem;
import com.alibaba.druid.sql.ast.statement.SQLSelectOrderByItem;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlSelectQueryBlock;
import com.alibaba.druid.util.JdbcUtils;
import com.alibaba.fastjson.JSON;
import com.weaver.inte.sql.druid.core.SqlParseCore;
import com.weaver.inte.sql.druid.entity.SqlParseEntity;

import java.util.List;

/**
 * @author: saps.weaver
 * @create: 2023-05-19 09:16
 **/
public class SqlParseTest {
    public static void main(String[] args) {
        String sql = "select " +
                " a.order_id, " +
                " count(b.id) as cnt, " +
                " uuid AS uuid, " +
                " uuid1 uuid2, " +
                " b.order_type AS orderType, " +
                " order_id AS orderId, " +
                " apply_tui_id AS applyTuiId  " +
                " from " +
                " fin_hotel_detail_data a " +
                " join fin_train_detail_data b on a.id = b.id " +
                " GROUP BY " +
                " order_id " +
                " having cnt > 10 " +
                " order by " +
                " cnt  " +
                " limit 0, 10";
        String sql2 = "select b.order_id,b.cnt,b.uuid as uid  from (  " +
                "SELECT  " +
                "  order_id,  " +
                "  count( 1 ) cnt,  " +
                "  uuid AS uuid,  " +
                "  order_type AS orderType,  " +
                "  order_id AS orderId,  " +
                "  apply_tui_id AS applyTuiId   " +
                "FROM  " +
                "  fin_hotel_detail_data   " +
                "GROUP BY  " +
                "  order_id   " +
                "HAVING  " +
                "  count( 1 ) > 10   " +
                "ORDER BY  " +
                "  count( 1 ) DESC   " +
                "  LIMIT 0,  " +
                "  10  " +
                "  ) b";
        //MySqlUnionQuery
        //MySqlSelectQueryBlock
        SqlParseEntity sqlParseEntity = SqlParseCore.buildQuery(sql, JdbcUtils.MYSQL);
        System.out.println(sqlParseEntity);
    }
}
