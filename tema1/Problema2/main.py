import re

def eliminare_semne_punctuatie(file):
    for line in file:
        x = re.sub(r"[^a-zA-Z0-9 ]", "", line)
        print(x)


def eliminare_spatii_multiple(file):
    for line in file:
        x = re.sub(r"\s+", " ", line)
        print(x)


def filtrare_nr_litere(file, nr):
    found = []
    for line in file:
        pattern = re.compile(r"\b\w{"+str(nr)+r"}\b")
        x = pattern.findall(line)
        for i in x:
            found.append(i)
    if len(found):
        print(f"Cuvintele cu {nr} litere din. inputul dat sunt:", end=" ")
        print(found)
    else:
        print(f"Nu exista cuvinte de lungime {nr} in inputul dat.")


f = open("input.txt", "r")
print("ELIMINARE SEMNE DE PUNCTUATIE:")
eliminare_semne_punctuatie(f)
print("ELIMINARE SPATII MULTIPLE:")
f.seek(0)
eliminare_spatii_multiple(f)
print("FILTRARE CUVINTE CU UN ANUMIT NUMAR DE LITERE")
f.seek(0)
filtrare_nr_litere(f, 4)