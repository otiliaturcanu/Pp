package org.example

class LibraryPrinter : RawBookPrinter, HTMLPrinter, JSONPrinter{
    override fun printHTML(books: Set<Book>) {
        println("\t\tPrinting books in HTML format")
        for(it in books){
            println(it.getName() + " was printed in HTML")
        }
    }

    override fun printJSON(books: Set<Book>) {
        println("\t\tPrinting books in JSON format")
        for(it in books){
            println(it.getName() + " was printed in JSON")
        }
    }

    override fun printRawBooks(books: Set<Book>) {
        println("\t\tPrinting books")
        for(it in books){
            println(it.getName() + " was printed")
        }
    }

}