import com.sun.xml.internal.fastinfoset.util.StringArray
import java.io.File


fun main(args:Array<String>) {
    var i= 0


    //Eliminare multiplu de"\n"
    var text = Array<String>(30) { "" }
    File("src/main/kotlin/org/example/Fisier.txt").forEachLine {
        it.reader().readText()
        if (it != "") {
            text[i] = it
            println(text[i])
            i++
        }



    }
    var j=0
    while(j<i)
    {
        text[j]=text[j].replace("^\\s{5,}[0-9]+\\s*".toRegex()," ")
        println(text[j])
        //val v = text[j].toCharArray()
        j++
    }

    //Eliminare spatii
    println("i="+i)
     j=0
    while(j<i)
    {
        text[j]=text[j].replace("\\s+".toRegex()," ")
        println(text[j])
        //val v = text[j].toCharArray()
        j++
    }

    //^\s*[0-9]*\s*


}