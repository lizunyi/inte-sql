package com.weaver.inte.sql;

import java.util.HashMap;
import java.util.Map;

import com.weaver.inte.utils.ReadWriteUtil;

/**
 * @description 
 * @author lzy
 * @date:2020年5月29日 下午6:33:22
 * @version v1.0
 */
public class Test {

	public static void main(String[] args) throws Exception {
		String sql = ReadWriteUtil.read("D:\\java-workspace\\inte-sql\\src\\main\\resources\\statAppVisitCount.sql");
		Map<String, Object> map = new HashMap();
		map.put("startDate", "2022-10-01");
		map.put("endDate", "2022-10-18 23:59:59");
		map.put("companyId", null);
		map.put("companyCode", null);
		System.out.println( SqlTemplete.parse(sql, map));
	}
}
