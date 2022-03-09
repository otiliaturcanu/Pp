def citire():
    nr_aruncari = input()
    nr_aruncari = int(nr_aruncari)
    while True:
        x = input()
        x = int(x)
        if x>=1 and x<=nr_aruncari:
            break
    return nr_aruncari, x

citire()
