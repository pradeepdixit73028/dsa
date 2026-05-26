# Write your MySQL query statement below
WITH RECURSIVE ManagerCounts AS(
    SELECT managerId,id AS rid
    FROM Employee
    WHERE managerId IS NOT NULL
    UNION ALL
    SELECT e.managerId,e.id
    FROM Employee e
    JOIN ManagerCounts mc ON e.id=mc.rid AND 1=0
)
SELECT name
FROM Employee
WHERE id IN(
    SELECT managerId
    FROM ManagerCounts
    GROUP BY managerId
    HAVING COUNT(DISTINCT rid)>=5
);
