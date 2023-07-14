import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
deck = deque([i+1 for i in range(N)])

def cardPlay(deck):
    deck.popleft()
    if len(deck) >= 2:
        deck.append(deck.popleft())
        return deck
    else:
        return deck

while len(deck) >= 2:
    cardPlay(deck)

print(deck[0])