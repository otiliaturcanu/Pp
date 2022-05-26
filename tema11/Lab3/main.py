import multiprocessing
from multiprocessing import  Process,Pipe


class ProcesTest(multiprocessing.Process):
    def run(self):
        print ('am apelat metoda run() in procesul: %s' %self.name)
        return


def alpha(conn):
    a=3
    jobs = [3, 10, 2, 11, 15]
    length=5
    i=0
    while i<length:
        jobs[i]=jobs[i]*a
        i+=1
    conn.send(jobs)
    conn.close()


def sort(conn, lista):
    n=len(lista)
    for i in range(n):
        for j in range(0,n-i-1):
            if(lista[j]>lista[j+1]):
                lista[j],lista[j+1]=lista[j+1],lista[j]
    conn.send(lista)
    conn.close()


if __name__ == '__main__':
    parent_conn,child_conn=Pipe()
    p=Process(target=alpha,args=(child_conn,))# procese care ruleaza si comunica prin pipeline, inmulteste
    p.start()
    p1=Process(target=sort,args=(child_conn,parent_conn.recv()))#sortare
    p1.start()
    print(parent_conn.recv())
    p.join()
    p1.join()
