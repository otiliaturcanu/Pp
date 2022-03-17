import java.io.File

fun main(args : Array<String>){
    val Dictionar = hashMapOf<String, String>()
    File("src/main/kotlin/org/example/Dictionar.txt").forEachLine {
        var split = it.split(":")
        if(split.size == 1) Dictionar.put(split[0], split[0])
        else Dictionar.put(split[0], split[1])
    }
    val Poveste = "Once upon a time there was an old woman who loved baking gingerbread. She would bake gingerbread cookies, cakes, houses and gingerbread people, all decorated with chocolate and peppermint, caramel candies and colored ingredients."
    val words1 = Poveste.split(" ")
    println("Cuvintele din poveste [${words1.count()}]:")
    for (word in words1)
        print(word + " ")
    val words2 = mutableListOf<String>()
    for (word in words1) {
        words2.add(word.trim(',', '.'))
    }
    println()
    while(true){
        println("0->Terminare, 1->Afisare dictionar, 2->Adaugare cuvant in dictionar, 3->Salvare in fisier a povestii: ")
        var x = readLine();
        if(x == "0") break;
        else if(x == "1"){
            println(Dictionar)
        }
        else if(x == "2"){
            println("Adaugati un cuvant in engleza in dictionar: ");
            var y = readLine();
            println("Adaugati traducerea cuvantului in dictionar: ")
            var z = readLine()
            Dictionar.set(y.toString(), z.toString());
            File("src/main/kotlin/org/example/Dictionar.txt").appendText("\n$y:$z")
            println("Cuvantul a fost adaugat in dictionar")
        }
        else if(x == "3"){
            var poveste : String
            poveste = ""
            for (item in words2){
                if (Dictionar.contains(item))
                    poveste += Dictionar[item] + " "
                else
                    poveste += item + " "
            }
            File("src/main/kotlin/org/example/Traducere.txt").writeText(poveste)
            println("S-a salvat povestea in fisierul Traducere.txt")
        }
    }
}

