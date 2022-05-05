package org.example

class Observable {

    private var observers = mutableListOf<Observer>()

    fun add(observer: Observer){
        this.observers.add(observer)
    }

    fun remove(observer: Observer){
        this.observers.remove(observer)
    }

    fun notifyAll(mess : String){
        for(obs in observers){
            if(mess.length <= 7){
                if(obs is SmallWordObserver) obs.update()
            }
            else(
                    if(obs is LargeWordObserver) obs.update()
            )
        }
    }

}