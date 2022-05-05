package org.example

class KidsBrowser(cleanGetRequest: CleanGetRequest?, postRequest: PostRequest?) {//facade -design pattern, ia mai multe op dif si le pune in ac clasa
    var e_cleanGetRequest = cleanGetRequest//le apeleaza pe toate
    var e_postRequest = postRequest

    fun start(){
        if(e_cleanGetRequest != null) println(e_cleanGetRequest?.getResponse())
        if(e_postRequest != null) println(e_postRequest?.postData())
    }

}