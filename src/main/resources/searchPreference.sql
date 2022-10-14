<if test="${searchPreference}==1">
    select * from (
    select b.prop_value as label,count(1) as count from trip_analysis a
    join trip_analysis_details b on a.id = b.analysis_id
    where
    prop_name = 'keyword'
    <if test="${startDate}">
        and operation_time >= ${startDate} and operation_time <= ${endDate}
    </if>
    <if test="${companyId}">
        and a.company_id = ${companyId}
    </if>
    group by b.prop_value
    order by count(1) desc
    ) a limit 0,20
</if>
<if test="${searchPreference}==2">
    select a.page_flag as label,count(1) as count from trip_analysis a
    where
    a.page_flag in
    (
    'filter_coupon','filter_price','filter_protocol_trustship','filter_protocol_changfan','filter_room_coupon','filter_room_protocol'
    )
    <if test="${startDate}">
        and operation_time >= ${startDate} and operation_time <= ${endDate}
    </if>
    <if test="${companyId}">
        and a.company_id = ${companyId}
    </if>
    group by a.page_flag
    order by count(1) desc
</if>