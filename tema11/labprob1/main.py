import math
import random
import threading
import multiprocessing
from concurrent.futures import ThreadPoolExecutor
import time


v = []

for i in range(0, random.randint(10, 25)):
    v.append(random.randint(-100, 100))


a = set()#multime nu am elem comune

for i in range(0, random.randint(10, 25)):
    a.add(random.randint(-100, 100))

def prim(x):
    if x <= 1:
        return False
    if x == 2:
        return True
    else:
        for it in range(2, int(math.sqrt(x))):
            if x % it == 0:
                return False
        return True

def countdown():
    v2 = v
    v2.sort()
    a_copy = []
    for it in a:
        if prim(it):
            a_copy.append(it)




def ver_1():
    thread_1 = threading.Thread(target=countdown)
    thread_2 = threading.Thread(target=countdown)
    thread_1.start()
    thread_2.start()
    thread_1.join()
    thread_2.join()


def ver_2():
    countdown()
    countdown()


def ver_3():
    process_1 = multiprocessing.Process(target=countdown)
    process_2 = multiprocessing.Process(target=countdown)
    process_1.start()
    process_2.start()
    process_1.join()
    process_2.join()


def ver_4():
    with ThreadPoolExecutor(max_workers=2) as executor:
        future = executor.submit(countdown())
        future = executor.submit(countdown())


if __name__ == '__main__':
    start = time.time()
    ver_1()
    end = time.time()
    print("\n Timp executie pseudoparalelism cu GIL")
    print(end - start)
    start = time.time()
    ver_2()
    end = time.time()
    print("\n Timp executie secvential")
    print(end - start)
    start = time.time()
    ver_3()
    end = time.time()
    print("\n Timp executie paralela cu multiprocessing")
    print(end - start)
    start = time.time()
    ver_4()
    end = time.time()
    print("\n Timp executie paralela cu concurrent.futures")
    print(end - start)