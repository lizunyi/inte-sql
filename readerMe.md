sql模板解析工具类  
语法：  
1. 支持 if表达式test中的逻辑运算

语法如下：
```	
   select * from trip_train_order_train where 1=1
   <if test="${train_code} < 1 ">
		and train_code like '${train_code}%'
   </if>
   <if test="${train_code} <= 1 ">
		and train_code like '${train_code}%' and code in ${ids}
   </if>
```
<if test="" > test表达式的逻辑运算符支持的有 >=、<=、>、<、==、!=、~~、^=、$=
其中
```					   
>=、<=、>、< 左右变量一定要是int类型
^= 为判断字符串开头是否包含
$= 为判断字符串结尾是否包含
~~ 为判断字符串中是否包含
== 为字符串等值判断(包含整形)
!= 为字符串不等值判断
```

2. 支持 if表达式的test非空运算

语法如下：
```	
   select * from trip_train_order_train where 1=1
   <if test="${train_code}">
		and train_code like '${train_code}%' 
   </if>
```
当train_code不为空的判断
-------------------------------------------------------------------
	Map<String, Object> map = new HashMap();
	map.put("train_code", "Z307");
	map.put("train_code2", "K571");
	map.put("train_code3", "K572");
	map.put("ids", Lists.newArrayList("as",123,"12312"));
	String sql = parse(sql, map);
	
