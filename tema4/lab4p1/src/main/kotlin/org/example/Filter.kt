package org.example

class Filter : AuthorFilter, NameFilter, PublisherFilter {

    private lateinit var library : Library

    fun setLibrary(lib : Library){
        this.library = lib
    }

    override fun findAllByAuthor(name: String): Set<Book> {
        var res = mutableSetOf<Book>()
        for(it in this.library.getBook()){
            if(it.getAuthor() == name){
                res.add(it)
            }
        }
        return res
    }

    override fun findAllByName(name: String): Set<Book> {
        var res = mutableSetOf<Book>()
        for(it in this.library.getBook()){
            if(it.getName() == name){
                res.add(it)
            }
        }
        return res
    }

    override fun findAllByPublisher(name: String): Set<Book> {
        var res = mutableSetOf<Book>()
        for(it in this.library.getBook()){
            if(it.getPublisher() == name){
                res.add(it)
            }
        }
        return res
    }

}