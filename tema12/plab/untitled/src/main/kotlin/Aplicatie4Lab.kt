import kotlin.properties.Delegates


fun Int.isPrime() : Boolean{
    if(this == 2)
        return true

    if(this % 2 == 0 || this == 1)
        return false

    val number = Math.abs(this)
    var index = 3

    while(index * index < number){
        if(number % index == 0)
            return false;
        index += 2;
    }
    return true;
}
var primeNumber : Int by Delegates.vetoable(2){
        property, oldValue, newValue ->
    println("${property.name} $oldValue -> $newValue")


    newValue.isPrime()
}



fun main(args:Array<String>){
    primeNumber = 1
    println("First assignation to primeNumber: $primeNumber")
    primeNumber = 13
    println("Second assignation to primeNumber: $primeNumber")
    primeNumber = 42
    println("Third assignation to primeNumber: $primeNumber")



}