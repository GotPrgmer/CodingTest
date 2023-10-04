-- 코드를 입력하세요
SELECT first_half.flavor
from first_half
inner join icecream_info
on first_half.flavor = icecream_info.flavor
where total_order >= 3000 and icecream_info.ingredient_type = 'fruit_based'