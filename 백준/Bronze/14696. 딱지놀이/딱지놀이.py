Round = int(input())
compare_A = [0,0,0,0]
compare_B = [0,0,0,0]

for _ in range(Round):
    A_list = list(map(int,input().split()))
    B_list = list(map(int,input().split()))
    compare_A = [0, 0, 0, 0]
    compare_B = [0, 0, 0, 0]

    for a in range(1,len(A_list)):
        compare_A[A_list[a]-1] += 1
    for b in range(1,len(B_list)):
        compare_B[B_list[b] - 1] += 1


    for result in range(3,-1,-1):
        if compare_A[result] > compare_B[result]:
            print('A')
            break
        elif compare_A[result] < compare_B[result]:
            print('B')
            break
    else:
        print('D')

