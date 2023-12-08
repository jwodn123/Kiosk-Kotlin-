package com.example.assignment_1.domain.product.burger

import com.example.assignment_1.domain.Product
import com.example.assignment_1.domain.menu.Burger

class SmokeShack: Product, Burger() {
    override var name: String = "SmokeShack"
    override var price: Double = 8.9
    override var description: String = "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"
}