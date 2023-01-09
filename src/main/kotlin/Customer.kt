import containers.Box
import containers.ShoppingCart
import flowers.Flower

class Customer(private val name: String, private var funds: Double) {
    private val shoppingCart = ShoppingCart(this)
    private var paid = false

    fun add(flowers: Flower) {
        shoppingCart.add(flowers)
    }

    fun getShoppingCart(): ShoppingCart = shoppingCart

    fun pay() {
        shoppingCart.removePriceless()
        funds = shoppingCart.processPayment(funds)
        paid = true
    }

    fun getCash(): Double = funds

    fun pack(box: Box) {
        if (!paid) {
            println("Nie zapłacono!")
        } else {
            box.pack(shoppingCart)
            shoppingCart.clear()
        }
    }

    override fun toString(): String {
        return name
    }


}