from queue import Queue
from threading import Thread, Condition
import time

q = Queue()#comunicarea dintre threaduri se face printr-o coada, coada este 2waycomunication, citim sau scriem in ea, coada e canal de comunicare

class Consumator(Thread):
    def __init__(self):
        Thread.__init__(self)

    def consumator(self):
        elemente = q.get()
        while True:
            if len(elemente) == 0:
                print('mesaj de la consumator: nu am nimic disponibil')
                break
            elemente.pop()
            print('mesaj de la consumator : am utlizat un element')
            print('mesaj de la consumator : mai am disponibil', len(elemente),
                  'elemente')

    def run(self):
        for i in range(5):
            self.consumator()


class Producator(Thread):#thread creaza un fir de executie
    def __init__(self):
        Thread.__init__(self)

    def producator(self):
        elemente = []
        while True:
            if len(elemente) == 10:
                print('mesaj de la producator : am disponibile', len(elemente),
                      'elemente')
                print('mesaj de la producator : am oprit productia')
                break
            elemente.append(1)
            print('mesaj de la producator : am produs', len(elemente), 'elemente')
        q.put(elemente)

    def run(self):
        for i in range(5):
            self.producator()


if __name__ == '__main__':
    producator = Producator()
    consumator = Consumator()
    producator.start()
    consumator.start()
    producator.join()#aduce rezultat
    consumator.join()

