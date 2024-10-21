def solution(arr):
    cur = arr[0]
    for i in range(1,len(arr)):
        min_num = min(cur,arr[i])
        bigger_num = max(cur,arr[i])
        cur = lcd(bigger_num,min_num)

    return cur
            

def gcd(a,b):
    while b:
        r = a%b
        a, b = b, r
    return a
def lcd(a,b):
    return a*b//gcd(a,b)