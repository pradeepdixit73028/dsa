# Write your MySQL query statement below
with ordered as(
    select *,
    lag(session_date) over(partition by student_id order by session_date)
    as prev_date
    from study_sessions
),marked as(
    select *,
    case
    when prev_date is null then 0
    when datediff(session_date,prev_date)<=2 then 0
    else 1
    end as is_break
    from ordered
),divided as(
    select *,
    sum(is_break) over(partition by student_id order by session_date)
    as divided_id
    from marked
),final as(
    select student_id,divided_id,
    count(*) as session_cnt,
    count(distinct subject) as cycle_length,
    sum(hours_studied) as total_study_hours
    from divided
    group by student_id,divided_id
    having cycle_length>=3 and session_cnt>=2*cycle_length
)
select f.student_id,s.student_name,s.major,f.cycle_length,f.total_study_hours
from students s
join final f
on f.student_id=s.student_id
order by f.cycle_length desc,f.total_study_hours desc;