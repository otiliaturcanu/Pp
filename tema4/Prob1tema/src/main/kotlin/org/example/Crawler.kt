package org.example

import com.sun.deploy.net.HttpResponse
import khttp.responses.Response
import org.jsoup.Jsoup

class Crawler {
    private var url : String = ""

    fun setUrl(url : String){
        this.url = url
    }

    fun getResource() : Response {
        val r = khttp.get(url)
        return r
    }

    fun processContent(contentType : String){
        if(contentType == "Json"){
            var r = getResource()
            var parser = JSONParser()
            parser.parse(r.text)
        }
    }
}