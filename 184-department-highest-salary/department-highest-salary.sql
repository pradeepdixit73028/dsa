# Write your MySQL query statement below
with cte as(
select d.name Department,e.name Employee,e.salary Salary,
dense_rank() over(partition by d.name order by salary) d_r
from Employee e join Department d
on e.departmentId=d.id
)
select Department, Employee, Salary
from cte e
where d_r=(select max(d_r) from cte f where e.department=f.department)