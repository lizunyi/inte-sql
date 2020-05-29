select * from trip_train_order_train where 
<if test="${id}"> 
	and train_code = '${id}'
</if>
union 
select * from trip_train_order_train where 
<if test="${id}"> 
	and train_code = '${id}'
</if>