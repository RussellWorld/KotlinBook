package com.bignerdranh.nyethack

import java.io.File

const val TAVERN_NAME = "Taernyl's Folly"


val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
val uniqeePatrons = mutableSetOf<String>()
val menuList = File("data/tavern-menu-items.txt")
    .readText()
    .split("|")
val patronGold = mutableMapOf<String, Double>()

fun main() {

    if (patronList.contains("Eli")) {
        println("The tavern master says: Eli's in the back playing cards.")
    } else
        println("The tavern master says : Eli isn't there.")

    if (patronList.containsAll(listOf("Sophie", "Mordoc"))) {
        println("The tavern master says: Yea, they're seated by the stew kettle.")
    } else
        println("The tavern master says : No, they departed hours ago.")


    (0..9).forEach {
        val first = patronList.shuffled().first()
        val lastName = lastName.shuffled().last()
        val name = "$first $lastName"
        uniqeePatrons += name
    }
    uniqeePatrons.forEach {
        patronGold[it] = 6.0
    }

    var orderCount = 0
    while (orderCount <= 9) {
        placeOrder(
            uniqeePatrons.shuffled().first(),
            menuList.shuffled().last()
        )
        orderCount++
    }
    displayPatronBalances()
}

private fun displayPatronBalances() {
    patronGold.forEach { patron, balance ->
        println("$patron, $balance: ${"%.2f".format(balance)}")
    }
}

fun performPurchase(price: Double, patronName: String) {
    val totalPurse = patronGold.getValue(patronName)
    patronGold[patronName] = totalPurse - price
}


fun placeOrder(patronName: String, menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$patronName speaks with $tavernMaster about their order.")

    val (type, name, price) = menuData.split(',')
    val message = "$patronName buys a $name ($type) for $price "

    println(message)

    performPurchase(price.toDouble(), patronName)

    val pharse = if (name == "Dragon's Breath") {
        "$patronName exclaims: ${toDragonsSpeak("Ah, delicious $name!")}"
    } else {
        "$patronName says: Thanks for the $name."
    }
    println(pharse)
}

private fun toDragonsSpeak(pharse: String) =
    pharse.replace(Regex("[aeiou]")) {
        when (it.value) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }



