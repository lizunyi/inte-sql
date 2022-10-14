select * from (
select ${bookPreference} as label,count(1) as count from hh_hotel_order where 1=1
<if test="${startDate}">
	and booking_date >= ${startDate} and booking_date <= ${endDate}
</if>
<if test="${companyId}">
	and company_id = ${companyId}
</if>
group by ${bookPreference}
order by count(1) desc
) a limit 0,10