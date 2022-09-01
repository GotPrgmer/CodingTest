r, c = map(int,input().split())
store_num = int(input())
store = []
now_x = ()
loc_sum = 0

for i in range(store_num + 1):
    if i == store_num:
        now_x = tuple(map(int,input().split()))
    else:
        store.append(tuple(map(int,input().split())))
for j in range(len(store)):
    if now_x[0] == 1:
        if store[j][0] == 1:
            loc_sum += abs(now_x[1]-store[j][1])
        elif store[j][0] == 2:
            loc_sum += min(c + r - store[j][1] + r - now_x[1] , c + store[j][1]+now_x[1])
        elif store[j][0] == 3:
            loc_sum += store[j][1] + now_x[1]
        else:
            loc_sum += r-now_x[1]+store[j][1]

    elif now_x[0] == 2:
        if store[j][0] == 1:
            loc_sum += min(c + r - store[j][1] + r - now_x[1], c + store[j][1] + now_x[1])
        elif store[j][0] == 2:
            loc_sum += abs(now_x[1] - store[j][1])
        elif store[j][0] == 3:
            loc_sum += c - store[j][1] + now_x[1]
        else:
            loc_sum += c - store[j][1] + r - now_x[1]

    elif now_x[0] == 3:
        if store[j][0] == 1:
            loc_sum += store[j][1] + now_x[1]
        elif store[j][0] == 2:
            loc_sum += c - now_x[1] + store[j][1]
        elif store[j][0] == 3:
            loc_sum += abs(now_x[1] - store[j][1])
        else:
            loc_sum += min(r + now_x[1] + store[j][1],r + c-now_x[1] + c-store[j][1])

    else:
        if store[j][0] == 1:
            loc_sum += now_x[1] + r-store[j][1]
        elif store[j][0] == 2:
            loc_sum += c - now_x[1] + r - store[j][1]
        elif store[j][0] == 3:
            loc_sum += min(r + c - store[j][1] + r - now_x[1],r + store[j][1] + now_x[1])
        else:
            loc_sum += abs(now_x[1] - store[j][1])


print(loc_sum)