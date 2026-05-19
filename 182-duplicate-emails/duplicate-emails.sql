# Write your MySQL query statement below
with cte as(
    select
        email as email,
        COUNT(email) as count
    from
        Person
    group by (email)
)
select email
from cte
where count>1