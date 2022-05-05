class Product {
    private var listaValori = mutableListOf<Boolean>()
    fun add(val1:Boolean){
        listaValori.add(val1)
    }
    fun list(){
        println(listaValori)
    }
    fun getListaValori():List<Boolean>{//ceea ce returneaza
        return listaValori
    }

}