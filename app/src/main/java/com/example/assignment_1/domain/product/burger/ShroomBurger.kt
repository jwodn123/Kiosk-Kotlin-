package com.example.assignment_1.domain.product.burger

import com.example.assignment_1.domain.Product
import com.example.assignment_1.domain.menu.Burger

class ShroomBurger: Product, Burger() {
    override var name: String = "Shroom Burger"
    override var price: Double = 9.4
    override var description: String = "몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거"
}