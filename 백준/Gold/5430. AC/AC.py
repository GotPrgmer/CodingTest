from collections import deque
T = int(input())

for _ in range(T):
    func = list(map(str,input()))
    num = int(input())
    if num != 0:
        num_list = deque(list(map(int,input().rstrip(']').lstrip('[').split(','))))
    else:
        t = input()
        num_list = deque(list([]))

    #앞이면 1 뒤면 -1
    flag = 1
    error = 0
    for i0 in range(len(func)):
        if func[i0] == 'R':
            flag = flag * -1
        else:
            if len(num_list) >= 1:
                if flag == 1:
                    num_list.popleft()
                else:
                    num_list.pop()
            else:
                error = 1
                break
    if error != 1:
        if len(num_list) == 0:
            print([])
        else:
            if flag == 1:
                print('[',end='')
                for i3 in range(len(num_list)):
                    if i3 == len(num_list)-1:
                        print(num_list[i3],end='')
                    else:
                        print(num_list[i3],end=',')
                print(']')
            elif flag == -1:
                num_list.reverse()
                print('[', end='')
                for i3 in range(len(num_list)):
                    if i3 == len(num_list) - 1:
                        print(num_list[i3], end='')
                    else:
                        print(num_list[i3], end=',')
                print(']')
                flag = 1
    else:
        print('error')
        error = 0
        flag = 1