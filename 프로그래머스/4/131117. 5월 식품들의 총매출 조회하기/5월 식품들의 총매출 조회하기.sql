select a.PRODUCT_ID,	a.PRODUCT_NAME,	sum(price*amount) as TOTAL_SALES
from FOOD_PRODUCT a
join FOOD_ORDER b on a.product_id = b.product_id
where date_format(produce_date,'%Y-%m') = '2022-05'
group by a.PRODUCT_NAME
order by TOTAL_SALES desc, a.PRODUCT_ID asc;

