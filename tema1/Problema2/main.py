import re

def eliminare_semne_punctuatie(file):
    for line in file:
        x = re.sub(r"[^a-zA-Z0-9 ]", "", line)
        print(x)


def eliminare_spatii_multiple(file):
    for line in file:
        x = re.sub(r"\s+", " ", line)
        print(x)


f = open("input.txt", "r")
print("ELIMINARE SEMNE DE PUNCTUATIE:")
eliminare_semne_punctuatie(f)
print("ELIMINARE SPATII MULTIPLE:")
f.seek(0)
eliminare_spatii_multiple(f)