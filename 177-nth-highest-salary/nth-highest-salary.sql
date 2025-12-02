CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
      select salary from (SELECT salary, DENSE_RANK() OVER (ORDER BY salary DESC) As ranking
      from employee)As ranked_salaries
      Where ranking=N
      limit 1
      
  );
END