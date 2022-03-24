package org.example

interface PaymentMethod {
    fun pay(fee : Double) : Boolean
}