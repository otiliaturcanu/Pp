class Abstraction(implementation: Implementation) {
    var e_implemenation = implementation
    fun operation(var1:Product):Boolean{
    return e_implemenation.getOutput(var1)
    }
}