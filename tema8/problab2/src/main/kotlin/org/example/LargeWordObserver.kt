package org.example

class LargeWordObserver: Observer {

    companion object {
        var words = 0;
    }

    override fun update() : Boolean {
        words++
        if(words == 7){
            words = 0
            return true
        }
        return false
    }

}