class ConcreteBuilder:Builder {
    private var produs = Product()
    fun reset(){
        produs = Product()//ca la new p
    }
    override fun product():Product{//functia de get
        var produsLivrat:Product = produs
        reset()
        return produsLivrat
    }

    override fun poartalogica2(val1: Boolean, val2: Boolean) {
        produs.add(val1)
        produs.add(val2)
    }

    override fun poartalogica3(val1: Boolean, val2: Boolean, val3: Boolean) {
        produs.add(val1)
        produs.add(val2)
        produs.add(val3)
    }

    override fun poartalogica4(val1: Boolean, val2: Boolean, val3: Boolean, val4: Boolean) {
        produs.add(val1)
        produs.add(val2)
        produs.add(val3)
        produs.add(val4)
    }

    override fun poartalogica8(
        val1: Boolean,
        val2: Boolean,
        val3: Boolean,
        val4: Boolean,
        val5: Boolean,
        val6: Boolean,
        val7: Boolean,
        val8: Boolean
    ) {
        produs.add(val1)
        produs.add(val2)
        produs.add(val3)
        produs.add(val4)
        produs.add(val5)
        produs.add(val6)
        produs.add(val7)
        produs.add(val8)
    }
}