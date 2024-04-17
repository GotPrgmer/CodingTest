one = 0
zero = 0

def solution(arr):
    global one
    global zero
    quad(arr,len(arr))
    return [zero,one]
    
def quad(arr,length):
    global one
    global zero
    count = 0
    for row in arr:
        for each in row:
            if each == 1:
                count += 1
                
    if count == length**2:
        one += 1
    elif count == 0:
        zero += 1
    else:
        quad([row[:length//2] for row in arr[:length//2] ],len(arr)//2)
        quad([row[length//2:] for row in arr[:length//2] ],len(arr)//2)
        quad([row[:length//2] for row in arr[length//2:] ],len(arr)//2)
        quad([row[length//2:] for row in arr[length//2:] ],len(arr)//2)
        
        
    
