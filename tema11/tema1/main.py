import asyncio
import time
from threading import Thread, Condition


async def say_after(delay, what):
    await asyncio.sleep(delay)
    print(what)


async def corutine1(n):
    s = 0
    for i in range(n):
        s += i
    print("s1=", s)


async def corutine2(n):
    s = 0
    for i in range(n):
        s += i
    print("s2=", s)


async def corutine3(n):
    s = 0
    for i in range(n):
        s += i
    print("s3=", s)


async def corutine4(n):
    s = 0
    for i in range(n):
        s += i
    print("s4=", s)


async def main():
    n1 = 10
    n2 = 25
    n3 = 50
    n4 = 75
    task1 = asyncio.create_task(corutine1(n1))

    task2 = asyncio.create_task(corutine2(n2))

    task3 = asyncio.create_task(corutine3(n3))

    task4 = asyncio.create_task(corutine4(n4))

    print(f"started at {time.strftime('%X')}")

    await task1
    await task2
    await task3
    await task4

    print(f"finished at {time.strftime('%X')}")

asyncio.run(main())