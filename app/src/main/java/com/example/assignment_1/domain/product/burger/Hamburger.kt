package com.example.assignment_1.domain.product.burger

import com.example.assignment_1.domain.Product
import com.example.assignment_1.domain.menu.Burger

class Hamburger: Product, Burger() {
    override var name: String = "Hamburger"
    override var price: Double = 5.4
    override var description: String = "비프패티를 기반으로 야채가 들어간 기본버거"
}