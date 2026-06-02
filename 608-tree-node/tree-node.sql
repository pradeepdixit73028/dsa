# Write your MySQL query statement below
WITH RECURSIVE Hierarchy AS(
    SELECT 
        id, p_id
    FROM Tree
    WHERE p_id IS NULL
    UNION ALL
    SELECT 
        t.id,t.p_id
    FROM Tree t
    INNER JOIN Hierarchy h ON t.p_id=h.id
)
SELECT 
    h.id,
    CASE 
        WHEN h.p_id IS NULL THEN 'Root'
        WHEN c.p_id IS NULL THEN 'Leaf'
        ELSE 'Inner'
    END AS type
FROM Hierarchy h
LEFT JOIN (SELECT DISTINCT p_id FROM Tree)c ON h.id=c.p_id;

		