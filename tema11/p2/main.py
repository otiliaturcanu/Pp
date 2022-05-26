import subprocess
first = subprocess.Popen(('ip', 'a'), stdout=subprocess.PIPE)#popen deschide u  pipeline, scrie cu stdoutin pipeline, in (a)
second = subprocess.Popen(('grep', 'inet'), stdin=first.stdout, stdout = subprocess.PIPE)#citeste din primul scrie in curent
third = subprocess.check_output(('wc', '-l'), stdin = second.stdout)#pune rezultatul i n thrird  care citeste din second
print(int(third))