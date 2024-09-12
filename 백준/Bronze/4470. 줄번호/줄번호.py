q = []
n = int(input())
for _ in range(n):
    q.append(input())
for i in range(len(q)):
    print(str(i+1)+". "+q[i])