package org.example

class Theatre {
    private var plays = mutableSetOf<Play>()

    fun addPlay(play : Play){
        this.plays.add(play)
    }

    fun getPlay() : Set<Play>{
        return this.plays
    }
}