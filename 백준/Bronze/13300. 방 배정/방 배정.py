students_number, limit_students = map(int,input().split())
dict_student = dict()
room = 0

for _ in range(students_number):
    student = tuple(input().split())
    if student in dict_student:
        dict_student[student] += 1
    else:
        dict_student.update({student : 1})
for element in dict_student.values():
    room += element // limit_students + int(bool(element % limit_students))
print(room)

