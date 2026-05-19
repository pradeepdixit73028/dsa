# Write your MySQL query statement below
with cte as
    (select id,salary
    from Employee where id in(select distinct managerId from Employee))

select e.name as Employee 
from Employee e left join cte 
on e.managerId=cte.id 
where e.salary>CTE.salary;