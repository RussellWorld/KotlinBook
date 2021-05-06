fun main() {
    var beverage = readLine()?.let {
        if (it.isBlank()) it.capitalize()
        else "Buttered Ale"
    }
//    beverage = null
    println(beverage)
}

fun readLine(): String? {
    return "beverage"
}