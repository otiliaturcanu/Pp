import org.example.RHistogram
import java.io.File

fun GetUniqueWordCount(all_words : List<String>) : MutableMap<String, Int>{
    val result:MutableMap<String, Int> = mutableMapOf<String, Int>()
    for(item in all_words){
        result[item] = result.getOrDefault(item, 0) + 1
    }
    return result
}

fun GetUniqueCharCount(all_chars : List<String>) : MutableMap<Char, Int>{
    val result:MutableMap<Char, Int> = mutableMapOf<Char, Int>()
    for(item in all_chars){
        result[item[0]] = result.getOrDefault(item[0], 0) + 1
    }
    return result
}


fun SortByHitCount(items : MutableMap<Char, Int>, how: Boolean) : MutableMap<Int, Char>{
    //functia de sortare a caracterelor, dupa valoare (frecventa), atat crescator cat si descrescator, in functie de how
    val result = mutableMapOf<Int, Char>()
    return result
}

//functia main()
fun main(args : Array<String>){
    //citim liniile din fisier
    val lines = File("src/main/kotlin/org/example/Fisier.txt").reader().readText()
    //construim un array de cuvinte, seprand prin spatiu
    val words = lines.split(" ")

    //eliminam semnele de punctuatie de pe marginile cuvintelor
    val trim_words = mutableListOf<String>()
    words.forEach {
        val filter = it.trim(',','.','"','?', '!')
        trim_words += filter.toLowerCase()
        print(filter + " ")
    }
    println("\n")

    //construim o lista cu toate caracterele folosite 'A..Z'
    val chars = mutableListOf<String>()
    trim_words.forEach {
        for (c in it){
            if (c in 'a'..'z' || c in 'A'..'Z') {
                chars += c.toUpperCase().toString()
                print(c.toUpperCase())
            }
        }
    }
    println("\n")

    //Pentru constructia histogramelor, R foloseste un mecanism prin care asociaza caracterelor unice, numarul total de aparitii (frecventa)
    // 1. Construiti in Kotlin acelasi mecanism de masurare a frecventei elementelor unice si afisati cuvintele unice din trim_words
    // 2. Construiti in Kotlin acelasi mecanism de masurare a frecventei elementelor unice si afisati caracterele unice din chars
    // 3. Pentru frecventele caracterelor unice caclulate anterior si
    //      A. Afisati perechile (frecventa -> Caracter) sortate crescator si descrescator
    //      B. afisati graficele variatiei de frecventa sortate anterior crescator si descrescator si concatenati-le intr-un grafic de puncte

    //construim histograma pentru cuvinte
    var met1:MutableMap<String, Int>
    met1 = GetUniqueWordCount(trim_words)
    println(met1)
    var met2:MutableMap<Char, Int>
    met2 = GetUniqueCharCount(chars)
    println(met2)
    RHistogram.BuildHistogram(trim_words.toTypedArray(), "Words", true)
    //construim histograma pentru caractere
    RHistogram.BuildHistogram(chars.toTypedArray(), "Chars", true)
}
