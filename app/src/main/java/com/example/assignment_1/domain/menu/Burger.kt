package com.example.assignment_1.domain.menu

import com.example.assignment_1.domain.Menu

open class Burger: Menu {
    override var name: String = "Burger"
    override var description: String = "앵거스 비프 통살을 다져만든 버거"

    override fun print() {
        println("${name}  | ${description}")
    }
}

