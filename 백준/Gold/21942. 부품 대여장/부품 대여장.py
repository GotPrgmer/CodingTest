# 부품 빌림 -> 부품 대여장 기록
# 부품 반납 -> 부품 대여장 기록
# 대여기간 정하고 대여 기간을 넘길 경우 1분당 벌금 부여
# 1분당 벌급도 주어짐

# 사람과 부품을 매칭해서 날짜 시간을 저장
# 부품을 반납하면 pop?
# 반납이 늦으면 얼마나 늦었는지 기록 즉
# 사람이름과 부품을 키로 (날짜, 시간,얼마나 늦었는지)
# 3개로 저장

import sys
import datetime
from collections import defaultdict

def input():
    return sys.stdin.readline().rstrip()

def late_check(author,bupum,h,m):
    # 연체기간 구해야함
    obj_time = datetime.datetime(2021,month = date_lst[1], day = date_lst[2],hour = h, minute= m)
    from_time = datetime.datetime(2021,month = dejang[(author,bupum)][0], day = dejang[(author,bupum)][1],hour = dejang[(author,bupum)][2], minute= dejang[(author,bupum)][3])
    return int((obj_time - from_time) / datetime.timedelta(minutes=1))

N, L, F = input().split()
N = int(N)
F = int(F)
# 부품 대장 딕셔너리
dejang = defaultdict(list)
# 정답 자료구조
ans = defaultdict(int)

#L을 일 시간으로 나눔
limit_date, limit_time = L.split("/")
limit_date = int(limit_date)
h, m = map(int,limit_time.split(":"))
limit_minute = limit_date*24*60 + h*60 + m


for _ in range(int(N)):
    date, time, bupum, author = input().split()
    #들어온 정보 N을
    # 날짜 시간으로 정리해서
    # 이름과 부품으로 딕셔너리를 검색해서 있는지 확인하고
    # 없으면 딕셔너리 추가
    # 있으면 정답 딕셔너리에 추가하고 지우기
    date_lst = list(map(int,date.split("-")))
    hh, mm = map(int,time.split(":"))
    if not dejang[(author,bupum)] :
        dejang[(author,bupum)].extend([date_lst[1],date_lst[2],hh,mm])
    else:
        #ans[(author]에 연체금 누적
        if limit_minute - late_check(author,bupum,hh,mm) < 0:
            ans[author] += (late_check(author,bupum,hh,mm) - limit_minute)*F

        del dejang[(author,bupum)]
if ans:
    for author in sorted(ans):
        print(author,ans[author])
else:
    print(-1)
