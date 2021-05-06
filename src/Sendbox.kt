fun main() {
    runSimulation()
}

fun runSimulation() {
    val gretingFunction = configureGreetingFunction()
    println(gretingFunction("Bob"))
}


fun configureGreetingFunction(): (String) -> String {
    val structrureType = "hospitals"
    var numBuildings = 5
    return { playerName: String ->
        val currentYear = 2021
        numBuildings += 1
        println("Adding $numBuildings $structrureType")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
}