package org.example

class CashPayment() : PaymentMethod {
    private var availableAmount : Double = 0.0

    fun setAmount(amount : Double){
        this.availableAmount = amount
    }

    fun getAmount() : Double{
        return this.availableAmount
    }

    override fun pay(fee: Double): Boolean {
        if(fee>this.availableAmount){
            return false
        }
        availableAmount -= fee
        return true
    }
}