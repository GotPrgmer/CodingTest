import sys
input = sys.stdin.readline

lst = []
line = int(input())

for i in range(line):
    inp = input().split()
    if len(inp)==2:
        command = inp[0]
        num = int(inp[1])
    else:
        command = inp[0]

    if command=='push':
        lst.append(num)
    elif command=='top':
        if len(lst)>0:
            print(lst[-1])
        else:
            print(-1)
    elif command=='size':
        print(len(lst))
    elif command=='empty':
        if len(lst)==0:
            print(1)
        else:
            print(0)
    elif command=='pop':
        if len(lst)>0:
            print(lst[-1])
            del lst[-1]
        else:
            print(-1)