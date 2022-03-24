package org.example

class Content(author : String? = null, text : String? = null) {
    private var author : String = ""
    private var text : String = ""
    fun setText(text : String){
        this.text = text
    }

    fun setAuthor(author : String){
        this.author = author
    }

    fun getAuthor() : String{
        return this.author
    }

    fun getText() : String{
        return this.text
    }
}