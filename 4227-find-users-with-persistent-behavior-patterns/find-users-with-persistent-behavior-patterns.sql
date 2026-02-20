# Write your MySQL query statement below
with cte as(
    select user_id,action_date,action,
    action_date-row_number()over(partition by user_id,action order by action_date)as consecutive
    from activity
),cte_con as(
    select user_id,action,count(*) as streak_length,min(action_date) as start_date,max(action_date) as end_date
    from cte
    group by user_id,action,consecutive
    having(count(*))>=5
)
select user_id,action,streak_length,start_date,end_date from cte_con

order by streak_length desc,user_id;