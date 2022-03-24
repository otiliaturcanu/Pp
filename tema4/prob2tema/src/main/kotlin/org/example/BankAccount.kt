package org.example

import java.util.Date

class BankAccount {
    private var availableAmount : Double = 0.0
    private var cardNumber : String = ""
    private var expirationDate : Date = Date()
    private var cvvCode : Int = 0
    private var userName : String = ""

    fun getAmount() : Double{
        return this.availableAmount
    }

    fun setAmount(amount : Double){
        this.availableAmount = amount
    }

    fun getCardNumber():String{
        return this.cardNumber
    }

    fun setCardNumber(s : String){
        this.cardNumber = s
    }

}