select 
    year(a.sales_date), 
    month(a.sales_date), 
    count(distinct(a.user_id)), 
    round(count(distinct(a.user_id))/(select count(*) from user_info where year(joined) = 2021),1)
from online_sale a inner join user_info b on a.user_id = b.user_id 
where year(b.joined) = 2021
group by 1,2
order by 1,2