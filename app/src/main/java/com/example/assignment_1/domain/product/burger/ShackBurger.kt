package com.example.assignment_1.domain.product.burger

import com.example.assignment_1.domain.Product
import com.example.assignment_1.domain.menu.Burger

class ShackBurger: Product, Burger() {
    override var name: String = "ShackBurger"
    override var price: Double = 6.9
    override var description: String = "토마토, 양상추, 쉑소스가 토핑된 치즈버거"
}