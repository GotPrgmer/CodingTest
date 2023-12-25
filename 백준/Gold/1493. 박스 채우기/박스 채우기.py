l, w, h = map(int,input().split())
total_vlm = l * w * h
N = int(input())
cube = [tuple(map(int,input().split())) for _ in range(N)]
cube.sort(reverse=True)

ans, total_cur = 0,0
for c_spec, c_cnt in cube:
    total_cur *= 8
    cube_leng = 2**c_spec
    #아무리 더한다 해도 초기 기둥에서 가능한 개수에서 현재까지 개수빼면 최대 차지할 수 있는 개수 구할 수 있음
    cnt_limit = (l // cube_leng) * (w // cube_leng) * (h // cube_leng) - total_cur
    
    cnt_limit = min(c_cnt,cnt_limit)
    
    ans += cnt_limit
    total_cur += cnt_limit
    
if total_cur == total_vlm:
    print(ans)
else:
    print(-1)