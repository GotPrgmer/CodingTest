import sys

def input():

    return sys.stdin.readline().rstrip()

M = int(input())

my_set = set()
for _ in range(M):
    this_input = input().split()
    op = this_input[0]
    if op == "add":
        num =int(this_input[1])
        my_set.add(num)
    elif op == "remove":
        num = int(this_input[1])
        if num in my_set:
            my_set.remove(num)

    elif op == "check":
        num = int(this_input[1])
        if num in my_set:
            print(1)
        else:
            print(0)
    elif  op == "toggle":
        num = int(this_input[1])
        if num in my_set:
            my_set.remove(num)
        else:
            my_set.add(num)

    elif op == "all":
        my_set = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}

    else:
        my_set = set()
