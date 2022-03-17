import java.util.Scanner
class Birth(val year: Int, val Month: Int, val Day: Int){
    override fun toString() : String{
        return "($Day.$Month.$year)"
    }
}

class Contact(val Name: String, val Phone: String, val BirthDate: Birth){
    fun Print() {
        println("Name: $Name, Mobile: $Phone, Date: $BirthDate")
    }
}


fun main(args : Array<String>){
    val reader = Scanner(System.`in`)
    val agenda = mutableListOf<Contact>()

    agenda.add(Contact("Mihai", "0744321987", Birth(1900, 11, 25)))
    agenda += Contact("George", "0761332100", Birth(2002, 3, 14))
    agenda += Contact("Liviu" , "0231450211", Birth(1999, 7, 30))
    agenda += Contact("Popescu", "0211342787", Birth(1955, 5, 12))
    for (persoana in agenda){
        persoana.Print()
    }
    println("Agenda dupa eliminare contact [George]:")
    agenda.removeAt(1)
    for (persoana in agenda){
        persoana.Print()
    }
    agenda.remove(Contact("Liviu" , "0231450211", Birth(1999, 7, 30)))
    println("Agenda dupa eliminare contact [Liviu]:")
    agenda.removeAt(1)
    for (persoana in agenda){
        persoana.Print()
    }
    print("Da-ti numele persoanei de cautat : ")
    var numeDeCautat : String = readLine().toString()
    for(persoana in agenda){
        if(persoana.Name == numeDeCautat){
            print("Persoana : ")
            persoana.Print();
            println("este in lista")
            break
        }
        else{
            println("Persoana cautata nu este in lista");
            break
        }
    }

    print("Da-ti numarul persoanei de cautat : ")
    var numarDeCautat : String = readLine().toString()
    for(persoana in agenda){
        if(persoana.Phone == numarDeCautat){
            print("Persoana : ")
            persoana.Print();
            println("este in lista")
            break
        }
        else{
            println("Persoana cautata nu este in lista");
            break
        }
    }

    print("Da-ti indicele persoanei pentru care se doreste schimbarea numarului : ")
    var index:Int = reader.nextInt()
    while(index < 0 || index > agenda.size)
    {
        print("INDICE NECORESPUNZATOR !!! - Da-ti indicele persoanei pentru care se doreste schimbarea numarului : ")
        index = reader.nextInt()
    }
    print("Da-ti noul numar al persoanei cu indicele : $index = ")
    var nrNou :String =  readLine().toString()
    agenda.set(index,Contact(agenda[index].Name,nrNou.toString(),agenda[index].BirthDate))
    println("Lista noua cu numarul modificat este : ")
    for (persoana in agenda){
        persoana.Print()
    }

}

