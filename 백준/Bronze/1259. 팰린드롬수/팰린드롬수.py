while True:
    lst = list(map(int,input()))
    if(len(lst)==1 and lst[0]==0):
        break
    else:
        if(lst==list(reversed(lst))):
            print("yes")

        else:
            print("no")

