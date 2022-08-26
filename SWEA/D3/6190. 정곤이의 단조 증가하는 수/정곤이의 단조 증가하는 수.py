def mono(number):
    for i in range(len(number)-1):
        if not(int(number[i]) <= int(number[i+1])):
            return False
    else:
        return True



T = int(input())

for tc in range(1, T + 1):
    number = int(input())
    input_list = list(map(int,input().split()))
    mono_list = []
    for i in range(0,number):
        for j in range(i+1,number):
            if mono(str(input_list[i] * input_list[j])):
                mono_list.append(input_list[i] * input_list[j])
    if not mono_list:
        print(f'#{tc} -1')
    else:
        print(f'#{tc} {max(mono_list)}')
