package org.example

import org.jsoup.Jsoup

var treeMap = mutableMapOf<String, MutableSet<String>>()

fun initializeMap(item : String) {
    var itemTrimmed = item
    if (item.startsWith("/")) {
        itemTrimmed = item.drop(1)
    }
    val splitList = itemTrimmed.split("/")

    var arr = treeMap.get("https://en.wikipedia.org")
    if (arr != null) {
        arr.add(splitList[0])
    } else {
        var set = mutableSetOf<String>()
        set.add(splitList[0])
        treeMap.put("https://en.wikipedia.org", set)
    }

}

fun main(args: Array<String>) {
    var urlregex = Regex("^\\/wiki[\\/]?.*")
    val doc = Jsoup.connect("https://en.wikipedia.org/wiki/Liskov_substitution_principle").get()
    var resultArray = doc.select("a[href]")    // <2>
                            .map { col -> col.attr("href") }    // <3>

                            .parallelStream()
                            .filter { it != null }


    var regexList = mutableListOf<String>()

    for(item in resultArray){
        for(it in urlregex.findAll(item)){
            regexList.add(it.value)
        }
    }
    println(regexList)
    initializeMap(regexList[0]);
    println(treeMap)
}
