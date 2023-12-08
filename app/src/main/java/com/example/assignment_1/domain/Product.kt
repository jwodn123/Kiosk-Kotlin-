package com.example.assignment_1.domain

interface Product {
    var name: String
    var price: Double
    var description: String

    fun print() {
        println("${name}  |  W ${price}  | ${description}")
    }
}