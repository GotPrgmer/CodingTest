import math
N = int(input())


def len_for_number(num):
    string_for_num = str(num)
    return len(string_for_num)


numbers = [False, False] + [True] * (N - 1)

ans = []
for i1 in range(2,int(math.sqrt(N))):
    st = i1
    if numbers[st]==True:
        for i2 in range(st*2, N + 1, i1):
            numbers[i2] = False

for i3 in range(7, len(numbers)):
    if numbers[i3]:
        # 상근수 구하기
        visited = set()
        stamp = i3
        start = i3
        while 1:
            tmp = 0
            str_num = len_for_number(start)
            for i4 in range(str_num, 0, -1):
                tmp += (start // (10 ** (i4 - 1))) ** 2
                start = start % (10 ** (i4 - 1))
            if tmp in visited:
                numbers[i3] = False
                break
            elif tmp == 1:
                ans.append(stamp)
                break
            else:
                start = tmp
                visited.add(tmp)
                continue

for answer in ans:
    print(answer)