import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

fun String.toDate(format : String) : LocalDate{
    val formatter = DateTimeFormatter.ofPattern(format, Locale.ENGLISH)
    val date = LocalDate.parse(this, formatter)

    return date
}

fun main(args:Array<String>){
    val toDay = "06/03/2022"
    val myDate = toDay.toDate("MM/dd/yyyy")

    println(myDate.toString())

}