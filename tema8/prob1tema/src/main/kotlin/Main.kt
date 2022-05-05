fun main(args: Array<String>) {
    var builder = ConcreteBuilder()
    builder.poartalogica3(true, false, true)
    var produs1 : Product = builder.product()
    var implementation = ConcreteImplementation()
    var abstraction = Abstraction(implementation)
    println(abstraction.operation(produs1))
    builder.poartalogica2(true, true)
    var produs2:Product = builder.product()
    println(abstraction.operation(produs2))
    builder.poartalogica4(true, true, false, true)
    var produs3:Product = builder.product()
    println(abstraction.operation(produs3))
    builder.poartalogica8(true, true, true, true, true,  true, true, true)
    var produs4:Product = builder.product()
    println(abstraction.operation(produs4))

}