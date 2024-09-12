import sys
from collections import defaultdict
sys.setrecursionlimit(10**6)
visited = set()
def solution(tickets):
    
    tickets.sort(key = lambda x:(x[0],x[1]))
    # print(tickets)
        
    ans = ["ICN"]

    answer = []
    def dfs(x):
        if len(visited)==len(tickets):
            answer.append(ans[:])
            return
        
        for i in range(len(tickets)):
            if tickets[i][0] == x and i not in visited:
                visited.add(i)
                ans.append(tickets[i][1])
                dfs(tickets[i][1])
                ans.pop()
                visited.remove(i)
        # return
    dfs("ICN")
    
    return answer[0]

