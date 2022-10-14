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
		String sql = ReadWriteUtil.read("D:\\java-workspace\\inte-sql\\src\\main\\resources\\searchPreference.sql");
		Map<String,String> map = new HashMap();
		map.put("id", "asd");
		map.put("searchPreference", "1");
		System.out.println( SqlTemplete.parse(sql, map));
	}
}
