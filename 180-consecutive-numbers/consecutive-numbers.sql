# Write your MySQL query statement below
with Recursive rec_cte(id,num,count)as(
    select id,num,1
      from logs l
    union all
    select l.id,l.num,rec.count+1
     from logs l
     join rec_cte rec
    where rec.id=l.id+1 and rec.num=l.num
)
 select distinct num as "ConsecutiveNums"
  from rec_cte rec
 where rec.count=3;