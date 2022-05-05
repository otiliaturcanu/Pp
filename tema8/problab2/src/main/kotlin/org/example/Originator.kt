package org.example

class Originator {
    private lateinit var message : String

    fun saveToMemento() : Memento{
        var mem = Memento()
        mem.setState(message)
        return mem
    }

    fun restoreFromMemento(memento: Memento){
        message = memento.getState()
    }

    fun setMessage(message:String){
        this.message = message
    }

}