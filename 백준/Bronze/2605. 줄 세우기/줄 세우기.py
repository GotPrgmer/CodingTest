student_number = int(input())
original_student_sequence = []
changing_sequence = []
number_pickup = list(map(str,input().split()))


for i in range(student_number):
    original_student_sequence.insert(i-int(number_pickup[i]),str(i+1))
print(' '.join(original_student_sequence))

