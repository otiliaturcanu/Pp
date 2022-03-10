size = len(cuvinte)
a = []
for i in range(size):
    if cuvinte[i] in a:
        continue
    a.append(cuvinte[i])
    ok = 0
    for j in range(size):
        if i != j:
            if suma[i] == suma[j] :
                if ok == 0:
                    print(cuvinte[i]+": "+ cuvinte[j],end = "")
                    ok = 1
                else:
                    print(","+cuvinte[j],end = "")
    if ok == 1:
        print("\n")
