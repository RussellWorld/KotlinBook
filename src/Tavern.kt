fun main() {
    var beverage = readLine()
    beverage = null
    if (beverage != null)
        beverage = beverage.capitalize()
    else
        println("I can't do that without - beverage is null!")

    val beverageServed: String = beverage ?: "Buttered Alle"
    println(beverageServed)
}

fun readLine(): String? {
    return "beverage"
}