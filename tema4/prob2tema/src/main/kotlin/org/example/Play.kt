package org.example

class Play(name: String, fee : Double) {
    private var fee = fee
    private val name = name

    fun getFee() : Double{
        return this.fee
    }

    fun getName() : String{
        return this.name
    }

    override fun toString() : String{
        return this.name + " " + this.fee
    }
}