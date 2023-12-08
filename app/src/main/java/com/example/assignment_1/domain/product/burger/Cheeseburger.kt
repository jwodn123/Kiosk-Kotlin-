package com.example.assignment_1.domain.product.burger

import com.example.assignment_1.domain.Product
import com.example.assignment_1.domain.menu.Burger

class Cheeseburger: Product, Burger() {
    override var name: String = "Cheeseburger"
    override var price: Double = 6.9
    override var description: String = "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"

    override fun print() {
        println("${name}  |  W ${price}  | ${description}")
    }
}