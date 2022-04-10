from abc import ABC
import os
import sys
from collections import deque


class GenericFile(ABC):
    pass


class TextASCII(GenericFile):
    def __init__(self, PathAbsolut):
        self.PathAbsolut = PathAbsolut
        f = open(self.PathAbsolut, 'r')
        dic = {}  # dictionar in python mapa set de chei
        for cuv in f.readlines():
            for c in cuv:
                if c in dic.keys():
                    dic[c] = dic[c] + 1
                else:
                    dic.setdefault(c, 1)
        totalchar = 0
        flagchar = 0

        for item in dic.keys():  # ia toate cheile  A din dictionar
            totalchar += dic[item]  #:2
            if ord(item) in [9, 10, 13] or (ord(item) >= 32 and ord(item) <= 127):
                flagchar += dic[item]

        self.frecvente =flagchar / totalchar
        f.close()

    def GetPath(self):
        return self.PathAbsolut

    def GetFreq(self):

        return self.frecvente


class XMLFile(TextASCII):
    def __init__(self, PathAbsolut, frecvente, FirstTag): self.PathAbsolut(PathAbsolut), self.frecvente(
        frecvente), self.FirstTag(FirstTag)

    # self.PathAbsolut=PathAbsolut
    # self.frecvente=frecvente
    # self.FirstTag=FirstTag
    def GetFirstTag(self):
        return self.FirstTag


class TextUNICODE(GenericFile):
    def __init__(self, PathAbsolut):
        self.PathAbsolut = PathAbsolut
        f = open(self.PathAbsolut, 'r')
        dic = {}  # dictionar in python mapa set de chei
        for cuv in f.readlines():
            for c in cuv:
                if c in dic.keys():
                    dic[c] = dic[c] + 1
                else:
                    dic.setdefault(c, 1)
        totalchar = 0
        if '0' not in dic.keys():
            flagchar = 0
        else:
            flagchar = dic['0']
        for item in dic.keys():  # ia toate cheile  A din dictionar
            totalchar += dic[item]  #:2

        self.frecvente = flagchar / totalchar
        f.close()

    def GetPath(self):
        return self.PathAbsolut

    def GetFreq(self):
        return self.frecvente


class Binary(GenericFile):
    def __init__(self, PathAbsolut, frecvente):
        self.PathAbsolut = PathAbsolut
        self.frecvente = frecvente

    def GetPath(self):
        return self.PathAbsolut

    def GetFreq(self):
        return self.frecvente


class BMP(Binary):
    def __init__(self, PathAbsolut, frecvente, Width, Height, BPP):
        self.PathAbsolut = PathAbsolut
        self.frecvente = frecvente
        self.Width = Width
        self.Height = Height
        self.BPP = BPP

    def ShowInfo(self):
        print(self.PathAbsolut + self.frecvente + self.Weidth + self.Height + self.BPP)


rootdir = sys.argv[1]  # ia calea dupa py main.py

for root, subFolders, files in os.walk(rootdir):
    for file in files:
        filePath = rootdir + '/' + file
        obj = TextUNICODE(filePath)
        if obj.GetFreq() >= 0.30:
            print(filePath + "  e unicode")
        else:
            obj =TextASCII(filePath)
            if obj.GetFreq() > 0.75:
                print(filePath + "  e text ascii")
            else:
                print(filePath + "  e text binar")

print(os . getcwd()) #instructiune ce afiseaza calea curenta
