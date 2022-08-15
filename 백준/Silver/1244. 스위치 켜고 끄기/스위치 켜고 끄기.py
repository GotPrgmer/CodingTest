T = int(input())

bulb = list(map(int,input().split()))
student_number = int(input())
for _ in range(student_number):
    student, rule = map(int,input().split())
    if student == 1:
        for man in range(rule-1, T, rule):
            bulb[man] = int(not(bulb[man]))
    else:
        for woman in range(min(rule, T - rule+1)):

            if bulb[rule-1-woman] == bulb[rule-1+woman]:
                bulb[rule-1-woman] = bulb[rule-1+woman] = int(not(bulb[rule-1+woman]))
            else:
                break

for i in range(len(bulb)):
    if (i + 1) % 20 == 0:
        print(bulb[i])
    else:
        print(bulb[i],end=' ')




