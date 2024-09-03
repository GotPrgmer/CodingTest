lst = list(map(int,input().split()))
sort_lst = sorted(lst)
reverse_lst = sorted(lst,reverse=True)
if lst== sort_lst:
    print("ascending")
elif lst == reverse_lst:
    print("descending")
else:
    print("mixed")