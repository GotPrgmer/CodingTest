import sys

def input():
    return sys.stdin.readline().rstrip()


str_lst = list(input())
result = ['']*len(str_lst)

def sol(arr,start):
    if not arr:
        return
    #알파벳중에 가장 작은 것
    min_value = min(arr)
    #현위치에서 min_value검색해서 인덱스 알아내기
    idx =  arr.index(min_value)
    #현위치에서 idx뒤에 있는 곳에 min_value알파벳놓기
    result[start+idx] = min_value
    print("".join(result))
    #찾은 idx보다 뒤에있는 값들 중에서 넣을게 있냐?
    sol(arr[idx+1:],start+idx+1)
    #idx앞부분에서는 찾을게 있냐?
    sol(arr[:idx],start)

sol(str_lst,0)


