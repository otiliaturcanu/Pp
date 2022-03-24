package org.example

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class Note {
    private var title : String = ""
    private var content : Content? = null
    private var date : String? = null

    fun getTitle() : String{
        return this.title
    }

    fun setTitle(title: String){
        this.title = title
    }

    fun setContent(content: Content){
        this.content = content
    }

    fun getContent():Content?{
        return this.content
    }

    fun getDate() : String{
        val current = LocalDateTime.now()

        val formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
        val formatted = current.format(formatter)

        this.date = formatted
        return formatted
    }
}