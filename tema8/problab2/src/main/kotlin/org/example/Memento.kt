package org.example

class Memento {
    private var state : String = ""

    fun getState() : String{
        return state
    }

    fun setState(state : String){
        this.state = state
    }
}