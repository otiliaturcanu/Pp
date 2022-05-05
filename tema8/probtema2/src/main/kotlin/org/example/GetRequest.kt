package org.example

import khttp.get
import khttp.responses.Response

class GetRequest(url : String, params : Map<String, String>?, timeout: Int) : HTTPGet {//proxy-design pattern limitam ce face program fct de conditii
    private var e_timeout = timeout
    private var e_GenericRequest = GenericRequest(url, params).clone()

    override fun getResponse(): Int {//primim rasp accesare site
//        println(e_GenericRequest.getUrl())
//        var response = get(e_GenericRequest.getUrl())
//        return response

        println("Timeout $e_timeout ...")
        println("Connecting to " + e_GenericRequest.getUrl() + " ...")
        return 200//succes

    }

    fun getParams() : Map<String, String>?{
        return e_GenericRequest.getParams()
    }

}