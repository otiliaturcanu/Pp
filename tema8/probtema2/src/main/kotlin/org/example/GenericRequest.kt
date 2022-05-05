package org.example

class GenericRequest(url:String, params : Map<String, String>?) : Cloneable {//Cloneable interfata, prototype design pattern aici construim urls toate pe care le vom plasa
    var e_url = url
    private var e_params : Map<String, String>? = null

    init {
        if(params != null) e_params = params
    }

    public override fun clone() : GenericRequest{
        return GenericRequest(e_url, e_params)
    }

    fun getUrl():String{
        return e_url
    }

    fun getParams():Map<String, String>?{
        return e_params
    }
}