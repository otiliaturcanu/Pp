import re

def eliminare_semne_punctuatie(file):
    for line in file:
        x = re.sub(r"[^a-zA-Z0-9 ]", "", line)
        print(x)


f = open("input.txt", "r")
print("ELIMINARE SEMNE DE PUNCTUATIE:")
eliminare_semne_punctuatie(f)