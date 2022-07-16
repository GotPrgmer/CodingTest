line = int(input())
for i in range(line):
    rc, count = map(int,input().split())
    Matrix = [[0]*rc for i in range(rc)]
    answer = 0
    cnt = 0
    for j in range(rc):
        row = list(map(int,input().split()))
        Matrix[j]= row

    for k in range(rc):
        for l in range(rc):
            if Matrix[k][l]==1:
                cnt+=1
            else:
                if cnt == count:
                    answer +=1
                else:
                    cnt=0
        for l in range(rc):
            if Matrix[l][k]==1:
                cnt+=1
            else:
                if cnt == count:
                    answer +=1
                else:
                    cnt=0
    print(answer)

        #가로에서 구해서 cnt에 누적시키고
        #세로에서 구해서 cnt에 누적시킨다.