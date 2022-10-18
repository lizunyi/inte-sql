select sum(count) as count from
(
select date(operation_time),count(distinct member_id) as count from trip_analysis where page_flag = 'app_home'
<if test="${startDate}">
	and operation_time >= '${startDate}' and operation_time <= '${endDate}'
</if>
<if test="${companyId}">
	and company_id = ${companyId}
</if>
group by date(operation_time)
) a