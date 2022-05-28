import sys
input = sys.stdin.readline
def compare(lst,X):
    for i in lst:
        if(i<X):
            print(i,end=" ")


num,X = input().split()
lst = input().rstrip().split(' ')
X = int(X)
lst = list(map(int,lst))
compare(lst,X)
