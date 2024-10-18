def solution(absolutes, signs):
    s = 0
    for i in range(len(absolutes)):
        if signs[i] == True:
            s += absolutes[i]
        else:
            s -= absolutes[i]
    return s