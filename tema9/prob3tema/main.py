import time

import requests

class Logger:

    def __init__(self, url):
        self.url = url

    def log(self):
        f = open("cache.txt", "a")#adaugam langa ce este
        f.write(self.url + ",")
        f.write(str(time.time()) + ",")
        response = requests.get(self.url)
        f.write(str(response.status_code))
        f.write("\n")
        f.close()
        return response.status_code

    def response(self):#veriffica daca avem ceva in cache anterioir
        f = open("cache.txt", "r")

        lines = f.readlines()

        for line in lines:
            if self.url in line:
                line_split = line.split(",")
                t = float(line_split[1])
                if time.time() - t >= 3600:#a trecut o ora
                    line_split[1] = str(time.time())
                    return line_split[2]
                else:
                    return line_split[2]
        return False


class Proxy:

    def __init__(self, logger):
        self.logger = logger


    def check_url(self):
        f = open("cache.txt", "r")

        lines = f.readlines()

        for line in lines:
            if self.logger.url in line:
                return True
        return False


    def request(self):
        if self.check_url():
            return self.logger.response()
        else:
            return self.logger.log()


if __name__ == '__main__':

    log = Logger("https://www.google.com")
    p = Proxy(log)
    print(p.request())

    log2 = Logger("https://www.facebook.com")
    p2 = Proxy(log2)
    print(p2.request())

    log3 = Logger("https://www.google.com")
    p3 = Proxy(log3)
    print(p3.request())