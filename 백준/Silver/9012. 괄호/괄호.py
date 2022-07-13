import sys
input = sys.stdin.readline

num = int(input())
lst = []

for i in range(num):
    string = input()
    #'('가 나오면 스택에 넣고
    lst = []
    for j in string:
        if j =='(':
            lst.append('(')
        elif j ==')':
            if len(lst)>=1 and lst[-1]=='(':
                del lst[-1]
            elif len(lst)==0 or lst[-1]==')':
                lst.append(')')
                break
    if len(lst)==0:
        print('YES')
    else:
        print('NO')