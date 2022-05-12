from abc import ABC
from subprocess import call


class Handler(ABC):#handler interfata care este implementta abstracthandlee
    def set_next(self, handler):
        pass

    def handle(self, request):
        pass


class AbstractHandler(Handler):
    _next_handler = None

    def set_next(self, handler):
        self._next_handler = handler
        return handler

    def handle(self, request):
        if self._next_handler:
            return self._next_handler.handle(request)

        return None


class KotlinHandler(AbstractHandler):
    def handle(self, request):
        for i in request:
            if "fun" in i:#daca avem fun in vrio linie
                return ExecuteCommand(request, "kotlinc").execute()

        return super().handle(request)


class JavaHandler(AbstractHandler):
    def handle(self, request):
        for i in request:
            if "public static void main(String[] args)" in i:
                return ExecuteCommand(request, "javac").execute()  # Faci

        return super().handle(request)#daca  nu e java trei la urm


class PythonHandler(AbstractHandler):
    def handle(self, request):
        for i in request:
            if 'if __name__ == "__main__"' in i:
                return ExecuteCommand(request, "python").execute()  # Faci
        return super().handle(request)


class Command(ABC):
    def execute(self):
        pass


class ExecuteCommand(Command):
    def __init__(self, file, type):
        self.file = file
        self.type = type

    def execute(self):
        with open("script.txt", "r") as self.file:
            print(call([f'{self.type}', 'script.txt']))


if __name__ == "__main__":

    f = open("script.txt", "r")

    k = KotlinHandler()
    j = JavaHandler()
    p = PythonHandler()

    k.set_next(j).set_next(p)
    k.handle(f.readlines())

