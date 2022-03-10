def input():
    f = open("src/dataset.txt", "r")
    line = f.readline()
    x = []
    while line:
        line = line.split(",")
        line = [int(c) for c in line]
        x.append(line)
        line = f.readline()
    f.close()
    return x
input()
