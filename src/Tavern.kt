import kotlin.math.roundToInt

const val TAVERN_NAME = "Taernyl's Folly"
var playGold = 10
var playSilver = 10


fun main() {

    placeOrder("shandy,Dragon's Breath,5.91")

}

fun performPurchase(price: Double) {
    displayBalance()


    val totalPrice = playGold + (playSilver / 100.0)
    println("Total purse: ${"%.2f".format(totalPrice)}")
    println("Purchasing item for $price")

    val remainingBalance = totalPrice - price

    println("Remaining balance: ${"%.2f".format(remainingBalance)}")

    val remainingGold = remainingBalance.toInt()
    val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
    playGold = remainingGold
    playSilver = remainingSilver
    displayBalance()
}

private fun displayBalance() {
    println("Player's purse balance: Gold: $playGold, Silver: $playSilver")
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

fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")

    val (type, name, price) = menuData.split(",")
    val message = "Madrigal buys a $name ($type) for $price."
    println(message)

    performPurchase(price.toDoubleOrNull() ?: 0.0)

    val pharse = if (name == "Dragon's Breath")
        "Madrigal exclaims: ${toDragonsSpeak("Ah, delicious $name!")}"
    else "Madrigal says: Thanks for the $name."
    print(pharse)


}

