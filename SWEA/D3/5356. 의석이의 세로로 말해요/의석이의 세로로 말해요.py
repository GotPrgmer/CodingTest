T = int(input())
string_list = []
max_elements = 0

for tc in range(1,T+1):
    string_list = []
    for _ in range(5):
        str_input =input()
        string_list.append(str_input)
        if max_elements < len(str_input):
            max_elements = len(str_input)
    print(f'#{tc}',end=' ')
    for col in range(max_elements):
        for i in string_list:
            if len(i) < col+1:
                continue
            else:
                print(i[col], end='')
    print()




