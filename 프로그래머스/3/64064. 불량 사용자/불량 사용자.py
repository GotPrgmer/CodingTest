import sys
sys.setrecursionlimit(10**6)
def solution(user_id, banned_id):
    #만족하는 문자열
    #banned_id에 따른 일치하는 문자열 리스트로 정리
    visited = set()
    check = [0 for _ in range(len(user_id))]
    def recur(x):
        nonlocal check
        if x >= len(banned_id):
            tmp = tuple(check)
            if tmp not in visited:
                visited.add(tmp)
                return
            return
        
        for u in range(len(user_id)):
            cur_user = user_id[u]
            #문자열 일치
            if len(cur_user) == len(banned_id[x]):
                cnt = 0
                cur = banned_id[x]
                for i in range(len(cur_user)):
                    if cur_user[i] == cur[i] or cur[i] == '*':
                        # print(cnt)
                        cnt += 1
                    else:
                        break
                # print(cnt,len(cur_user))
                if cnt == len(cur_user) and check[u]==0:
                    check[u] = 1
                    recur(x+1)
                    check[u] = 0
        return
    recur(0)
    print(len(visited))
    answer = 0
    return len(visited)