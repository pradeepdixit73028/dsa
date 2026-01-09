# Write your MySQL query statement below
select p.product_id,coalesce((
    select pp.new_price
    from Products pp
    where p.product_id=pp.product_id
    and pp.change_date<='2019-08-16'
    order by pp.change_date desc
    limit 1
),10) as price
from(select distinct product_id from Products)p;