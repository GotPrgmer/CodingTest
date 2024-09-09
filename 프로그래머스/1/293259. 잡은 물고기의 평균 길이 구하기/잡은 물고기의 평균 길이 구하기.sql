-- 코드를 작성해주세요

select round(avg(ifnull(length,10)),2) as AVERAGE_LENGTH
from FISH_INFO