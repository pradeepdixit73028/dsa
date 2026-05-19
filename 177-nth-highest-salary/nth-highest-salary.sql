CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      # Write your MySQL query statement below.
        with cte as(
            select row_number() over (order by salary desc) pid,
            salary from Employee
            group by salary
        )
        select salary from cte
        where pid=N
  );
END