# Write your MySQL query statement below
WITH RECURSIVE Hierarchy AS(
    SELECT 
        id, p_id,1 AS depth
    FROM Tree
    WHERE p_id IS NULL
    UNION ALL
    SELECT 
        t.id,t.p_id,h.depth+1 AS depth
    FROM Tree t
    INNER JOIN Hierarchy h ON t.p_id=h.id
)
SELECT t.id,
    CASE 
        WHEN t.p_id IS NULL 
         THEN 'Root'
         WHEN t.id NOT IN 
         (SELECT DISTINCT p_id 
            FROM Tree 
            WHERE p_id IS NOT NULL) 
         THEN 'Leaf'
        ELSE 'Inner'
    END AS type
FROM Tree t;

		