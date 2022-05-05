package org.example

class PostRequest(url : String, params: Map<String, String>?) {//la fel ca si get request
    var e_genericRequest = GenericRequest(url, params)

    fun postData() : Int{
        println("Posting to ${e_genericRequest.getUrl()}...")
        return 200
    }
}