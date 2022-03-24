package org.example

interface PublisherFilter {
    fun findAllByPublisher(name : String) : Set<Book>
}