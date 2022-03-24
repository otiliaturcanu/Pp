package org.example

import java.io.File

class JSONParser : Parser {
    override fun parse(text: String): Map<String, String> {
        var r = text.split(",")
        val fisier = File("output_.json").writer()
        for(it in r){
            fisier.write(it)
        }
        fisier.close()
        var result = mutableMapOf<String, String>()
        return result
    }
}