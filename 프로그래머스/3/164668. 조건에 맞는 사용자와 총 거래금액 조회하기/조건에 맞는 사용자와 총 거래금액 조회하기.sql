SELECT USER_ID,	NICKNAME, sum(a.price) as TOTAL_SALES
from USED_GOODS_BOARD a
join USED_GOODS_USER b on a.writer_id = b.user_id
where a.status = 'DONE'
group by user_id

having sum(a.price)>=700000
order by TOTAL_SALES asc;