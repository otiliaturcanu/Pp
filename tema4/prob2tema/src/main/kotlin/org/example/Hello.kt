package org.example

fun main(args: Array<String>) {

    var t1 = Theatre()

    t1.addPlay(Play("Anabelle", 25.0))
    t1.addPlay(Play("Constantiopol", 15.99))

    for(i in t1.getPlay()){
        println(i)
    }

    var p1 = Person("card", 30.0)
    p1.goToPlay(t1.getPlay().elementAt(1))
    p1.goToPlay(t1.getPlay().elementAt(0))

}

