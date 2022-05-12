import copy
from abc import ABC

class File(ABC):

    def __init__(self):
        self.paragraphs = None
        self.author = None
        self.title = None

    def read_file_from_stdin(self):
        self.title = input()
        self.author = input()
        nrparagrafe = int(input())#transforma string in int
        self.paragraphs = []#lista stringuri
        for i in range  (nrparagrafe):
            self.paragraphs.append(input())

class HTMLFile(File):
    def __init__(self):
        super().__init__()

    def print_html(self):
        t = f"""
            
            <html>
                <head>
                    <title>{self.title}</title>
                    <meta author={self.author}>
                </head>
                <body>
                
            """
        print(t)
        for i in self.paragraphs:
            print(f"<p>{i}</p>")
        print("""
                </body>
            </html>
            """)

class JSONFile(File):
    def __init__(self):
        super().__init__()

    def print_json(self):
        t = f"""
                "author": "{self.author}"
                "title" : "{self.title}"
            """
        print(t)
        print("paragraphs: [", end="")
        for i in self.paragraphs:
            print(f'"{i}",', end="")
        print("]")

class FileFactory:
    def factory(self, tip):
        if tip == "HTML":
            h = HTMLFile()
            h.read_file_from_stdin()
            return h
        elif tip == "JSON":
            j = JSONFile()
            j.read_file_from_stdin()
            return j
        elif tip == "BLOG":
            b = BlogTextFile()
            b.read_file_from_stdin()
            return b.clone()
        elif tip == "ARTICLE":
            a = ArticleTextFile()
            a.read_file_from_stdin()
            return a.clone()


class TextFile(File, ABC):#daca e abstracta sau interfata punem abc
    def __init__(self):
        super().__init__()#super se refera la clasa de baza
        self.template = None

    def print_text(self):
        t = f""" 
            Template: {self.template}
            Titlu: { self.title}
            Autor: {self.author}            
            """
        print(t)
        for i in self.paragraphs:
            print(i)


    def clone(self):
        return copy.copy(self)


class ArticleTextFile(TextFile):

    def __init__(self):
        self.template = "Article"

    def print_text(self):
        t = f"""
                    {self.title}
                        by {self.author}
            """

        print(t)
        for i in self.paragraphs:
            print(i)


class BlogTextFile(TextFile):

    def __int__(self):
        self.template = "Blog"

    def print_text(self):
        print(self.title)
        for i in self.paragraphs:
            print(i)
        print()
        print(f"Written by {self.author}")

if __name__ == "__main__":
    f = FileFactory()
    h = f.factory("HTML")
    h.print_html()

    j = f.factory("JSON")
    j.print_json()

    blog = f.factory("BLOG")
    blog.print_text()

    article = f.factory("ARTICLE")
    article.print_text()