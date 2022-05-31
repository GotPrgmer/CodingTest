str = input()
cnt = 0
if(('c=') in str):
    cnt += str.count('c=')
    str=str.replace('c=',' ')
if(('c-') in str):
    cnt += str.count('c-')
    str=str.replace('c-',' ')
if(('dz=') in str):
    cnt += str.count('dz=')
    str=str.replace('dz=',' ')

if(('d-') in str):
    cnt += str.count('d-')
    str=str.replace('d-',' ')

if(('lj') in str):
    cnt += str.count('lj')
    str=str.replace('lj',' ')

if(('nj') in str):
    cnt += str.count('nj')
    str=str.replace('nj',' ')

if('s=' in str):
    cnt += str.count('s=')
    str=str.replace('s=',' ')
if(('z=') in str):
    cnt += str.count('z=')
    str=str.replace('z=',' ')
str = str.replace(' ','')
cnt+=len(str)
print(cnt)
