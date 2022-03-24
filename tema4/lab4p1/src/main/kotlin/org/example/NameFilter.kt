package org.example

interface NameFilter {
    fun findAllByName(name : String) : Set<Book>
}