import sys

def input():
    return sys.stdin.readline().rstrip()

word_set = set()

N = int(input())

for _ in range(N):
    word_set.add(input())

word_lst = list(word_set)
word_lst.sort(key= lambda x: (len(x),x))

for word in word_lst:
    print(word)
