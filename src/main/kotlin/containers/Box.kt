package containers

import Customer
import PriceList

class Box(customer: Customer) : FlowerContainer(customer) {

    fun pack(source: FlowerContainer) {
        items.addAll(source.items)
    }

    fun totalPriceByColor(color: String): Double = items.filter { it.color == color }
            .fold(0.0) { total, flower -> total + PriceList.getPrice(flower.name) * flower.amount }

    override fun toString(): String = "Pudełko" + super.toString()
}