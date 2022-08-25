
for tc in range(1, 11):
    length = int(input())
    input_list = list(map(str,input()))
    post_fix = ''
    stack = []

    for i in input_list:
        if i == '(':
            stack.append(i)
        elif i == '*' or i == '/':
            while stack and (stack[-1] == '*' or stack[-1] == '/'):
                post_fix += stack.pop()
            stack.append(i)

        elif i == '+' or i == '-':
            while stack and (stack[-1] == '*' or stack[-1] == '/' or stack[-1] == '+' or stack[-1] == '-'):
                post_fix += stack.pop()
            stack.append(i)
        #i가 )일 경우
        elif i == ')':
            while stack and stack[-1] != '(':
                post_fix += stack.pop()
            stack.pop()
        else:
            post_fix += i
    while stack:
        post_fix += stack.pop()

    for i in post_fix:
        if not i.isnumeric():
            num1 = stack.pop()
            num2 = stack.pop()
            if i == '+':
                stack.append(int(num2) + int(num1))
            elif i == '-':
                stack.append(int(num2) - int(num1))
            elif i == '*':
                stack.append(int(num2) * int(num1))
            elif i == "/":
                stack.append(int(num2) // int(num1))
        else:
            stack.append(i)
    print(f'#{tc} {stack.pop()}')
