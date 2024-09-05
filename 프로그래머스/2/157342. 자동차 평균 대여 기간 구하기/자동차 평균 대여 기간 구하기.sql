select CAR_ID, round(avg(DATEDIFF(a.END_DATE,a.START_DATE)+1),1) as AVERAGE_DURATION
from CAR_RENTAL_COMPANY_RENTAL_HISTORY a
group by car_id
having AVERAGE_DURATION >= 7
order by AVERAGE_DURATION desc, car_id desc