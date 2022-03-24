package org.example

class Person(payment : String, amount : Double) {
    private var payment = payment
    private var amount = amount
    private lateinit var payMethod : PaymentMethod

    fun goToPlay(p : Play){
        if(payment == "cash"){
            var cash = CashPayment()
            cash.setAmount(this.amount)
            if(cash.pay(p.getFee())){
                println("Am mers la piesa " + p.getName())
                amount = cash.getAmount()
            }
            else println("Nu am suficienti bani sa merg la piesa " + p.getName())
        }
        else{
            var card = CardPayment()
            var bankAccount = BankAccount()
            card.setAccount(bankAccount)
            bankAccount.setAmount(this.amount)
            if(card.pay(p.getFee())){
                println("Am mers la piesa " + p.getName())
                amount = bankAccount.getAmount()
            }
            else println("Nu am suficienti bani sa merg la piesa " + p.getName())
        }
    }
}