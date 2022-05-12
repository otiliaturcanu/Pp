from os import listdir
from os.path import isfile, join

def file_filter(path):
    files = [f for f in listdir(path) if isfile(join(path, f))]#lisdir contine tot ce e ein direttor, isfile daca calea e fisier pune in vector
    for f in files:
        yield f#asteapta sa fie apelat

def file_text_filter(files):
    returndata = []
    for file in files:
        if ".txt" in file:
            returndata.append(file)

    for rd in returndata:
        yield rd

def file_line_counter(textfiles):
    for file in textfiles:#adica rd
        f = open(join("/home/student/Otilia/PP/tema9/lab2/path1/", file), "r")#read ce ein fisier
        fr = f.readlines()
        count = 0
        for i in fr:
            count+=1
        yield f"{file}: {count}"#returneaza file si count

if __name__ == "__main__":
    pipeline = file_line_counter(file_text_filter(file_filter("/home/student/Otilia/PP/tema9/lab2/path1")))
    for i in pipeline:
        print(i)