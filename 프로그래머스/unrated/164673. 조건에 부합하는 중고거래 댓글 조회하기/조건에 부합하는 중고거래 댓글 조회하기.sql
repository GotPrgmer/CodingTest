-- 코드를 입력하세요
SELECT D.TITLE, D.BOARD_ID, Y.REPLY_ID,  Y.WRITER_ID, Y.CONTENTS, to_char(Y.CREATED_DATE, 'yyyy-mm-dd') as created_date
from USED_GOODS_BOARD D, USED_GOODS_REPLY Y
where D.board_id = y.board_id and to_char(D.CREATED_DATE, 'yyyymm') = '202210'
order by y.created_date, d.title

