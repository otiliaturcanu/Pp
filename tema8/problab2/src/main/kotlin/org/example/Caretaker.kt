package org.example

class Caretaker {

    private var savedStates = mutableListOf<Memento>()

    fun addMemento(memento: Memento){
        this.savedStates.add(memento)
    }

    fun getSavedStates() : List<Memento>{
        return savedStates
    }

}