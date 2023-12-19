import sys
sys.setrecursionlimit(100000)


def input():
    return sys.stdin.readline().rstrip()

#맨오른쪽부터 하나씩 넣는게 제일 좋을거라고생각
#하지만 없는부분을 스캔하는거때문에 시간초과
#그래서 각게이트에 다음사용해야할것을 저장하면좋겠다는
#생각을하게됨

G = int(input())
P = int(input())

parent = [i for i in range(G+1)]

def find(x):
    if parent[x] != x:
        parent[x] = find(parent[x])
    return parent[x]

def union(x,y):
    x = find(x)
    y = find(y)

    if x < y:
        parent[y] = x
    else:
        parent[x] = y
ans = 0
doc = []
for _ in range(P):
    cur = int(input())
    doc.append(cur)

for i0 in doc:
    cur_p = find(i0)
    if cur_p:
        union(cur_p,cur_p-1)
        ans +=1
    else:
        break

print(ans)