package org.example

class Library {
    private var books = mutableSetOf<Book>()

    fun getBook() : Set<Book>{
        return this.books
    }

    fun addBook(book : Book){
        this.books.add(book)
    }
}