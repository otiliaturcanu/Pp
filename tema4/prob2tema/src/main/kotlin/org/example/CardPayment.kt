package org.example

class CardPayment : PaymentMethod {

    private var bankAccount = BankAccount()

    fun setAccount(bank : BankAccount){
        this.bankAccount = bank
    }

    override fun pay(fee: Double): Boolean {
        var amount = this.bankAccount.getAmount()
        if(fee > amount) return false
        this.bankAccount.setAmount(amount-fee)
        return true
    }
}