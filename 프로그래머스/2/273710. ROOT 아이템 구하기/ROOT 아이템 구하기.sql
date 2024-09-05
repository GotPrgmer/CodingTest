select a.ITEM_ID,	a.ITEM_NAME
from ITEM_INFO a
join ITEM_TREE b on a.item_id = b.item_id
where parent_item_id is null
order by a.item_id asc;