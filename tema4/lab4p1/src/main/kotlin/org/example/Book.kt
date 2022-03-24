package org.example

class Book(content: Content) : Publishable{
    private var data = content

    fun getName() : String{
        return this.data.getName()
    }

    fun getAuthor() : String{
        return this.data.getAuthor()
    }

    fun getPublisher() : String{
        return this.data.getPublisher()
    }

    fun getContent() : String{
        return this.data.getText()
    }

    fun hasAuthor(name : String) : Boolean{
        if(this.getAuthor() == name) return true
        return false
    }

    fun hasTitle(title: String) : Boolean{
        if(this.getName() == title) return true
        return false
    }

    override fun toString() : String{
        return this.getName() + "\t" + this.getAuthor() + "\t" + this.getPublisher() + "\t" + this.getContent()
    }

    override fun isPublishedBy(name: String): Boolean {
        if(this.getPublisher() == name) return true
        return false
    }
}