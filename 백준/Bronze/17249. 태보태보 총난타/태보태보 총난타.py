str_input = input()
left_count = 0
right_count = 0
left = list(str_input[:str_input.index('(')].split('@'))
right = list(str_input[str_input.index(')')+1:].split('@'))
for i in left:
    if i:
        left_count += 1
for i in right:
    if i:
        right_count += 1
print(left_count,end= ' ')
print(right_count)
