from collections import deque
N = int(input())
alpha_dic = dict({'A':0,'B':0,'C':0,'D':0,'E':0,'F':0,'G':0,'H':0,'I':0,
                                          'J':0,'K':0,'L':0,'M':0,
                                        'N':0,'O':0,'P':0,'Q':0,'R':0,
                                          'S':0,'T':0,'U':0,'V':0,
                  'W':0,'X':0,'Y':0,'Z':0,})


expressions = deque(list(map(str,input())))
execute = deque([])

#피연산자 받기
for i0 in range(N):
    alpha_dic[chr(65+i0)] = int(input())


for i1 in range(len(expressions)):
    if expressions[i1].isalpha():
        execute.append(alpha_dic[expressions[i1]])
    else:
        oper = expressions[i1]
        a = float(execute.pop())
        b = float(execute.pop())
        if oper == '+':
            execute.append(float(b+a))
        elif oper == '-':
            execute.append(float(b-a))
        elif oper == '/':
            execute.append(float(b/a))
        else:
            execute.append(float(b*a))
        continue



print('{:.2f}'.format(float(execute[-1])))
