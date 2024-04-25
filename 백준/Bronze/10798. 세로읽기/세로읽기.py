import sys

def input():
    return sys.stdin.readline().rstrip()

string_lst = []
for _ in range(5):
    input_string = input()
    if not input_string:
        break
    else:
        string_lst.append(input_string)
idx = 0
ans = ''
while True:
    tmp = ''
    for string in string_lst:
        if idx <= len(string) - 1:
            tmp += string[idx]
    if len(tmp) == 0:
        print(ans)
        break
    else:
        idx += 1
        ans += tmp
        continue
