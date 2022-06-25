string =input()

def lowerupperchanger(string):
    for i in string:
        if i.isupper():
            print(i.lower(),end='')
        else:
            print(i.upper(),end='')

lowerupperchanger(string)