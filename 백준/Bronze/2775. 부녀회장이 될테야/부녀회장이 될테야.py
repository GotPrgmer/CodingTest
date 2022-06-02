residents = int(input())
for number in range(residents):
    floor = int(input())
    room = int(input())
    population = [[0 for j in range(room)] for i in range(floor)]
    
    for i in range(room):
        population[0][i]= i+1 #0층을 i명의 사람으로 고정
    if(floor==1): #1층에 입주하려 할 때는 0층의 사람들수를 다 더하면 됨.
        print(sum(population[0]))
    else:
        for j in range(0,floor-1):
            for k in range(0,room):
                summ = 0
                for l in range(0,k+1):
                    summ += population[j][l]
                population[j+1][k]=summ
        print(sum(population[floor-1]))
        # print(sum(population[floor-1]))
