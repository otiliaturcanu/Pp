package org.example

fun main(args: Array<String>) {
    var lib = Library()

    var c1 = Content()
    c1.setText("Andrei are mere")
    c1.setAuthor("Jeff")
    c1.setName("Andrei")
    c1.setPublisher("Carta")

    var c2 = Content()
    c2.setText("Ana are mere")
    c2.setAuthor("Jeff")
    c2.setName("Ana")
    c2.setPublisher("Carta")

    var c3 = Content()
    c3.setText("Venus e a 2-a planeta in Sistemul solar")
    c3.setName("Venus, Sistemul Solar")
    c3.setAuthor("Iulian Popescu")
    c3.setPublisher("Atlas")

    var b1 = Book(c1)
    println(b1)
    var b2 = Book(c2)
    println(b2.hasAuthor("Jeff"))
    var b3 = Book(c3)
    println(b3.isPublishedBy("Carta"))

    lib.addBook(b1)
    lib.addBook(b2)
    lib.addBook(b3)

    var printer = LibraryPrinter()
    var printSet = mutableSetOf<Book>()
    printSet.add(b1)
    printSet.add(b2)
    printer.printHTML(printSet)

    var filter = Filter()
    filter.setLibrary(lib)
    println(filter.findAllByPublisher("Atlas"))
}

