for _ in range(3):
    n = int(input())
    ans = 0
    for _ in range(n):
        value = int(input())
        ans += value
    if ans >0:
        print("+")
    elif ans <0:
        print("-")
    else:
        print(0)