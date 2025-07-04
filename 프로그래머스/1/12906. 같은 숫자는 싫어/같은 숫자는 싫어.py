from collections import deque
def solution(arr):
    st = deque()
    for i in range(len(arr)):
        if(len(st)==0):
            st.append(arr[i])
        
        elif(st[-1] != arr[i]):
            st.append(arr[i])
        
    # [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
    ans = []
    while(len(st)!=0):
        ans.append(st.pop())
    ans.reverse()
    return ans