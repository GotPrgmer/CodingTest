total = int(input())
kg_3=0
kg_5=0
for i in range(total//5,-1,-1):
    kg_3 = (total-5*i)/3
    if ( kg_3-((total-5*i)//3)==0):
        kg_5=i
        print(int(kg_5+kg_3))
        break
    elif(i==0):
        print(-1)