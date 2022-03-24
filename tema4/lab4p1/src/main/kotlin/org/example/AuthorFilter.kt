package org.example

interface AuthorFilter {
    fun findAllByAuthor(name : String) : Set<Book>
}