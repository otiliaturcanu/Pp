from abc import ABC
from collections import deque
class Celula(ABC):
    pass

class fibra_musculara(Celula):
    def __init__(self,nume,masaMusculara):
        self.nume=nume
        self.masaMusculara=masaMusculara
    def GetNume(self):
        return self.nume
    def GetMasaMusculara(self):
        return self.masaMusculara
class muschi_generic :
    fibe=[]
    def __init__(self,nume,masaMusculara,scop):
        self.nume=nume
        self.masaMusculara=masaMusculara
        self.scop=scop
        self.fibe.append(fibra_musculara(nume,masaMusculara))
    def GetNume(self):
        return self.nume
    def GetMasaMusculara(self):
        return self.masaMusculara
    def GetScop(self):
        return self.scop
    def afisare(self):
        print("Masa musculara a muschilor[" + self.nume, "]=", self.masaMusculara)

class muschi_mana(muschi_generic):
    def __init__(self,nume,masaMusculara,scop):
        super().__init__(nume,masaMusculara,scop)
    def afisare(self):
        super().afisare()


class muschi_picioare(muschi_generic):
    def __init__(self,nume,masaMusculara,scop):
        super().__init__(nume,masaMusculara,scop)
    def afisare(self):
        super().afisare()
class fibra_nervoasa(Celula):
    def __init__(self,nume,lungime):
        self.nume=nume
        self.lungime=lungime
    def GetNume(self):
        return self.nume
    def GetLungime(self):
        return self.lungime




class trunchi_nervos:
    nervi=[]
    def __init__(self,nume,lungime,specializare):
        self.nume=nume
        self.lungime=lungime
        self.specializare=specializare
        self.nervi.append(fibra_nervoasa(nume,lungime))
    def GetNume(self):
        return self.nume
    def GetLungime(self):
        return self.lungime
    def GetSpecializare(self):
        return self.specializare
    def afisare(self):
        print("Lungimea sistemului nervos[",self.nume,"]=",self.lungime)



class trunchiuri_coloana(trunchi_nervos):
    def __init__(self,nume,lungime,specializare):
        super().__init__(nume,lungime,specializare)
    def afisare(self):
        super().afisare()


if __name__ == '__main__':
    toti_muschii=[]
    toti_muschii.append(muschi_mana("Biceps stang",0.499,{"locomotor","incordare brat"}))
    toti_muschii.append(muschi_mana("Biceps drept",0.36,{"locomotor","incordare brat"}))
    toti_muschii.append(muschi_mana("Triceps stang",0.477,{"locomotor","relaxare brat"}))
    toti_muschii.append(muschi_mana("Triceps drept",0.491,{"locomotor","relaxare brat"}))
    toti_muschii.append(muschi_picioare("Gamba dreapta",0.4332,{"locomotor","incordare"}))
    toti_muschii.append(muschi_picioare("Gamba stanga",0.4665,{"locomotor","incordare"}))
    toti_muschii.append(muschi_generic("Stomac",1.2517,{"Digestie"}))
    s=0
    for i in toti_muschii:
        i.afisare()
        s=s+i.GetMasaMusculara()
    print("Masa totala a muschilor",s)
    sistem_nervos=[]
    sistem_nervos.append(trunchi_nervos("Emisfera Stanga",1439.199,{"Logica","Ratiune"}))
    sistem_nervos.append(trunchi_nervos("Emisfera Dreapta",1672.8,{"Afectivitate"}))
    sistem_nervos.append(trunchi_nervos("Cerebel",1088.6,"Echilibru"))
    sistem_nervos.append(trunchi_nervos("Maduva",1210.9,"Control reflexe"))
    s=0
    for i in sistem_nervos:
        i.afisare()
        s=s+i.GetLungime()
    print("Lungimea axiomilor din sistemul nervos: ",s)
    print("Urmatorii muschi au functie locomotorie:")
    for i in toti_muschii:
        for s in i.GetScop():
            if (s=="locomotor"):
                print(i.GetNume(),"['",s,"']")
