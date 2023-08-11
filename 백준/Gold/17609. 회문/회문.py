import sys

def input():
    return sys.stdin.readline().rstrip()
T = int(input())

ans = []

def isPalindrome(checkString,s,e,f):
    thisString = checkString
    start = s
    end = e
    flag = f
    while start < end:
        if thisString[start]==thisString[end]:
            start += 1
            end -= 1
        else:
            if(not flag and (not isPalindrome(thisString,start+1,end,True) or not isPalindrome(thisString,start,end - 1, True))):
                return 1
            else:
                return 2
    return 0
            #왼쪽 혹은 오른쪽을 하나 건너뛰고 회문돌렸을 때 회문이어야 함
            #둘 중에 하나만 걸리더라도 괜춘!

for _ in range(T):
    question = input()
    start = 0
    end = len(question) - 1
    check = isPalindrome(question,start,end,False)
    if check == 1:
        ans.append(1)
    elif check == 0:
        ans.append(0)
    else:
        ans.append(2)
for result in ans:
    print(result)