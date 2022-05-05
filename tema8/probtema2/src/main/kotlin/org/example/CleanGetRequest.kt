package org.example

class CleanGetRequest(getRequest: GetRequest) : HTTPGet {//se pun conditiile tot face parte proxy

    private var e_getRequest = getRequest
    private val parentalControlDisallow = mutableListOf<String>()

    init {
        parentalControlDisallow.add("Vulgar")
        parentalControlDisallow.add("Adult")
        parentalControlDisallow.add("Violent")
    }

    override fun getResponse(): Int {
        for(it in parentalControlDisallow){
            if(e_getRequest.getParams()?.values?.contains(it) == true){
                println("Can't connect to this website due to parental control")
                return 403//interzis forbidden
            }
        }
        return 200//succes coduri http
    }

}