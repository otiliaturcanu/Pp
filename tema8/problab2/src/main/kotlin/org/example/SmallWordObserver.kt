package org.example

class SmallWordObserver : Observer {

    companion object {
        var words = 0;
    }

    override fun update() : Boolean {
        words++
        if(words == 10){
            words = 0
            return true
        }
        return false
    }

}