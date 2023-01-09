package containers

import Customer
import PriceList
import flowers.Flower

class ShoppingCart(customer: Customer): FlowerContainer(customer) {
    fun add(flowers: Flower) {
        items.add(flowers)
    }

    fun removePriceless() {
        items.removeIf { !PriceList.has(it.name) }
    }

    fun processPayment(funds: Double): Double {
        var remainingFunds = funds
        val itemsIterator = items.iterator()
        while (itemsIterator.hasNext()) {
            val item = itemsIterator.next()
            val price = PriceList.getPrice(item.name) * item.amount
            if (price <= remainingFunds) {
                remainingFunds -= price
            } else {
                itemsIterator.remove()
            }
        }

        return remainingFunds
    }

    override fun toString(): String = "Wózek" + super.toString()
}