def solution(number, k):
    cnt = 0
    stack = []
    for i in range(len(number)):
        if len(stack) == 0:
            stack.append(number[i])
        else:
            while stack:
                if stack[-1]<number[i]:
                    stack.pop()
                    cnt += 1
                    if cnt == k:
                        return ''.join(stack) + number[i:]
                else:
                    break
            stack.append(number[i])
            if cnt == k:
                return ''.join(stack)+number[i+1:]
    return ''.join(stack[0:len(number)-k])