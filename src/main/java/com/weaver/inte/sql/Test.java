package com.weaver.inte.sql;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description 
 * @author lzy
 * @date:2020年5月29日 下午6:33:22
 * @version v1.0
 */
public class Test {

	public static void main(String[] args) throws Exception {
		String sql = "select (\n" +
				"case when supplier_type = '01' then '泰坦'\n" +
				" when supplier_type = '03' then '美团'\n" +
				" when supplier_type = '04' then '锦江'\n" +
				" when supplier_type = '06' then '携程'\n" +
				" when supplier_type = '07' then '客户托管'\n" +
				" when supplier_type = '08' then '东呈'\n" +
				" when supplier_type = '09' then '亚朵'\n" +
				" when supplier_type = '10' then '格林'\n" +
				" when supplier_type = '11' then '华住'\n" +
				" when supplier_type = '12' then '千淘'\n" +
				" when supplier_type = '13' then '同城'\n" +
				" when supplier_type = '14' then '畅帆协议'\n" +
				" when supplier_type = '15' then '秋果'\n" +
				" when supplier_type = '17' then '丽呈'\n" +
				" else supplier_type\n" +
				"end) as label,count(1) as count from hh_hotel_order\n" +
				"where length(supplier_type) > 0\n" +
				"<if test=\"${startDate}\">\n" +
				"\tand booking_date >= '${startDate}' and booking_date <= '${endDate}'\n" +
				"</if>\n" +
				"<if test=\"${companyId} && ${companyId2}\">\n" +
				"\tand company_id = ${companyId}\n" +
				"</if>\n" +
				"group by label\n" +
				"order by count(1) desc";

		Map<String, Object> map = new HashMap();
		map.put("companyId", "123132");
		map.put("companyId2", "123132");

		System.out.println( SqlTemplete.parse(sql, map));
	}
}
