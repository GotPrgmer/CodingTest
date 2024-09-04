select USER_ID,	NICKNAME, CONCAT_Ws(" ",a.CITY,a.STREET_ADDRESS1, a.STREET_ADDRESS2) as 전체주소,concat(substr(a.TLNO,1,3),'-',substr(a.TLNO,4,4),'-',substr(a.TLNO,8,4)) as 전화번호
from USED_GOODS_USER a
join USED_GOODS_BOARD b on a.user_id = b.WRITER_ID

group by USER_ID
having count(*) >=3
order by user_id desc;
