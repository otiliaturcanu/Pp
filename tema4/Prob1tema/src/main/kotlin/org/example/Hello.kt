package org.example

fun main(args: Array<String>) {
    var c = Crawler()
    c.setUrl("https://api.github.com/events")
    c.processContent("Json")
}

