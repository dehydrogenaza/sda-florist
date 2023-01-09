package containers

import Customer
import flowers.Flower

abstract class FlowerContainer(private val customer: Customer) {
    val items = mutableListOf<Flower>()

    fun clear() {
        items.clear()
    }

    override fun toString(): String {
        var str = " właściciel $customer"
        str += if (items.isEmpty()) " -- pusto" else items.joinToString {
            "\n${it.name}, kolor: ${it.color}, ilość ${it.amount}, cena ${PriceList.getPrice(it.name)}"
        }
        return str
    }
}