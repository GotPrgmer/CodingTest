import re

source = input()

main = re.findall('<main>(.*)</main>', source)[0]
div_list = re.findall('<div title="(.*?)">(.*?)</div>', main)

for title, paragraph in div_list:
    print('title :', title)
    p_list = re.findall('<p>(.*?)</p>', paragraph)
    for p in p_list:
        p = re.sub('(<.*?>)', '', p)
        p = re.sub('\s+', ' ', p.strip())
        print(p)