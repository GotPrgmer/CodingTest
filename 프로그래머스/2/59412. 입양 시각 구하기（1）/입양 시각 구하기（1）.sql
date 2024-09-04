-- 코드를 입력하세요
select hour(datetime) as HOUR ,count(*) as COUNT
from animal_outs
where hour(datetime) between '09' and '19'
group by HOUR
order by HOUR asc;