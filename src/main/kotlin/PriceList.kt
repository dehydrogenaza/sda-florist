object PriceList {
    @JvmStatic fun getInstance(): PriceList = this

    private val prices = mutableMapOf<String, Double>()

    fun put(productName: String, price: Double) {
        prices[productName] = price
    }

    fun has(productName: String) = prices.containsKey(productName)

    fun getPrice(productName: String) = prices[productName] ?: -1.0
}