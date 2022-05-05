class ConcreteImplementation:Implementation {
    override fun getOutput(product: Product):Boolean {
        for(item in product.getListaValori()){
            if(!item)
                return false
        }
        return true
    }

}