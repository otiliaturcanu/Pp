package org.example
import org.jsoup.Jsoup
import org.jsoup.select.Elements


fun main(){
    val websiteHTML= Jsoup.connect("http://rss.cnn.com/rss/edition.rss").get()
    val links : Elements = websiteHTML.select("rss channel item link")
    val titles : Elements = websiteHTML.select("rss channel item title")
    val linksString = mutableListOf<String>()
    val titleString = mutableListOf<String>()
    for(link in links)
    {
        val trim = link.toString()
        linksString.add(trim.substring(6,trim.length - 7))
    }
    for(title in titles)
    {
        val trim = title.toString()
        titleString.add(trim.substring(16,trim.length - 11))
    }
    val postari = mutableListOf<String>()
    titleString.zip(linksString).forEach{
        val a = it.component1()
        val b = it.component2()
        val postare_noua = "Titlul articolului : $a , Link: $b"
        postari.add(postare_noua)
    }
    for(post in postari){
        println(post)
    }

}