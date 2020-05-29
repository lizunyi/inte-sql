select * from trip_train_order_train where 

<if test="${id1}"> 
	and train_code = ${train_code2} and a = ${train_code2} and o in ${ids}
</if>
<if test="${id2aa}== 1"> 
	and train_code > 1 
</if>
<if test="${id3} >= 1"> 
	and train_code >= 1 
</if>
<if test="${id4}<1">and train_code<1</if>
<if test="${id5}<=  1"> 
	and train_code <= 1 
</if>
<if test="${id6} != 1"> 
	and train_code != 1 
</if>
<if test="${id7} $= 1"> 
	and train_code aa= 1 
</if>
<if test="${id8} ~~ 1"> 
	and train_code ~~ 1 
</if>

aa=${id2}