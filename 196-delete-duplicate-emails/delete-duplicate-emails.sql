# Write your MySQL query statement below
with cte as (
    select id,row_number() over(partition by email order by id) as rnk
    from Person
)
delete Person 
from Person 
join cte on Person.id=cte.id
where cte.rnk>1;