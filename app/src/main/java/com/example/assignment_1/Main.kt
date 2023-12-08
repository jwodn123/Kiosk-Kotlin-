package com.example.assignment_1

import com.example.assignment_1.domain.Product
import com.example.assignment_1.domain.product.burger.Cheeseburger
import com.example.assignment_1.domain.product.burger.Hamburger
import com.example.assignment_1.domain.product.burger.ShackBurger
import com.example.assignment_1.domain.product.burger.ShroomBurger
import com.example.assignment_1.domain.product.burger.SmokeShack
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


// 장바구니
class ShoppingCart {
    var items: MutableList<Product> = mutableListOf()
}

fun main() {
    var shoppingCart = ShoppingCart()
    mainMenu(shoppingCart)
}

// 메인 메뉴판
fun mainMenu(shoppingCart: ShoppingCart) {

    while (true) {
        println("SHAKESHACK BURGER에 오신걸 환영합니다.")
        println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.")
        println("\n[ SHAKESHACK MENU ]")
        println("1. Burger         | 앵거스 비프 통살을 다져만든 버거")
        println("2. Forzen Custard  | 매장에서 신선하게 만드는 아이스크림")
        println("3. Drink          | 매장에서 직접 만드는 음료")
        println("4. Beer            | 뉴욕 브루클린 브루어리에서 양조한 맥주")
        println("\n[ ORDER MENU ]")
        println("5. Order       | 장바구니를 확인 후 주문합니다.")
        println("6. Cancel      | 진행중인 주문을 취소합니다.")

        var choice = readLine()!!.toInt();

        when (choice) {
            in 1..4 -> showSubMenu(choice, shoppingCart)
            5 -> {
                placeOrder(shoppingCart)
            }
            6 -> cancelOrder(shoppingCart)
            else -> println("잘못된 선택입니다.")
        }
    }
}

// 상세 메뉴판
fun showSubMenu(category: Int, shoppingCart: ShoppingCart) {
    when (category) {
        1 -> {
            println("SHAKESHACK BURGER에 오신걸 환영합니다.")
            println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.")
            println("\n[ Burger MENU ]")
            val products = listOf(
                ShackBurger(),
                SmokeShack(),
                ShroomBurger(),
                Cheeseburger(),
                Hamburger()
            )
            displayProducts(products, shoppingCart)
        }
        // 추가적인 카테고리
        // 2 -> {}
    }
}

// 상세 메뉴 선택
fun displayProducts(products: List<Product>, shoppingCart: ShoppingCart) {
    for ((index, product) in products.withIndex()) {
        println("${index + 1}. ${product.name} | W ${product.price} | ${product.description}")
    }

    print("상품을 선택해주세요: ")
    var productChoice = readLine()?.toInt()

    if (productChoice != null && productChoice in 1..products.size) {
        addToCart(products[productChoice - 1], shoppingCart)
    } else {
        println("잘못된 선택입니다. 다시 선택해주세요.")
    }
}

// 구매(장바구니 추가)
fun addToCart(product: Product, shoppingCart: ShoppingCart) {
    println("${product.name} | W ${product.price} | ${product.description}")
    println("위 메뉴를 장바구니에 추가하시겠습니까?")
    println("1. 확인      2. 취소")

    var confirmationChoice = readLine()?.toInt()

    when (confirmationChoice) {
        1 -> {
            shoppingCart.items.add(product)
            println("${product.name} 가 장바구니에 추가되었습니다.")
        }
        2 -> println("추가를 취소하였습니다.")
        else -> println("잘못된 선택입니다.")
    }
}

// 주문
fun placeOrder(shoppingCart: ShoppingCart) {

    println("아래와 같이 주문 하시겠습니까?")
    println("\n[ Orders ]")
    for ((index, item) in shoppingCart.items.withIndex()) {
        println("${item.name} | W ${item.price} | ${item.description}")
    }

    val totalPrice = shoppingCart.items.sumByDouble { it.price }
    println("\n[ Total ]")
    println("W ${totalPrice}")
    println("\n1. 주문      2. 메뉴판")

    var choice = readLine()?.toInt()

    when (choice) {
        1 -> {
            println("주문이 완료되었습니다!")
            println("\n대기번호는 [ 1 ] 번 입니다.")
            println("(3초후 메뉴판으로 돌아갑니다.)")
            runBlocking {
                delay(3000) // Delay for 3 seconds
            }
            shoppingCart.items.clear()
        }
        2 -> {
            mainMenu(shoppingCart)
        }
        else -> {
            println("잘못된 선택입니다.")
        }
    }
}

// 취소주문
fun cancelOrder(shoppingCart: ShoppingCart) {

    println("진행하던 주문을 취소하시겠습니까?")
    println("\n1. 확인        2. 취소")

    var choice = readLine()?.toInt()

    when (choice) {
        1 -> {
            shoppingCart.items.clear()
            println("진행하던 주문이 취소되었습니다.")
            main()
        }
        2 -> {
            mainMenu(shoppingCart)
        }
    }
}



