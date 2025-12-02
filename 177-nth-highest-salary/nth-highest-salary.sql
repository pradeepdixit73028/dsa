CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
set n=n-1;
  RETURN (
      select (SELECT DISTINCT(salary) from Employee order by salary DESC
      LIMIT 1 OFFSET N)
      
  );
END