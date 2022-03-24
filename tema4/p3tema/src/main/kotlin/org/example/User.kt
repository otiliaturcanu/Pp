package org.example

class User {
    fun menu(){
        var c : String
        println("\t\tMENIU PENTRU APLICATIE")
        var manager = Manager()
        while(true){
            println("\t\tApasati una din urmatoarele taste:")
            println("\t0: Inchidere aplicatie")
            println("\t1: Afisarea tuturor notitelor")
            println("\t2: Selectare si afisare notita")
            println("\t3: Adaugare notita")
            println("\t4: Stergere notita")
            println()
            c = readLine().toString()
            if(c == "0") break
            else{
                if(c == "1"){
                    manager.listNotes()
                }
                else if(c == "2"){
                    println("Dati un titlu pentru notita cautata: ")
                    var titlu = readLine()
                    if (titlu != null) {
                        manager.showNote(titlu)
                    }
                }
                else if(c == "3"){
                    manager.createNote()
                }
                else if(c == "4"){
                    println("Dati titlul pentru notita pe care vreti sa o stergeti!")
                    var titlu = readLine()
                    if (titlu != null) {
                        manager.deleteNote(titlu)
                    }
                }
                else{
                    println("Comanda nu este valida, incercati alta comanda din lista data.")
                }
            }
        }
    }
}