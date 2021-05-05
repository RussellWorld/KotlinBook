fun main() {
    val name = "Mandrigal"
    var healthPoint = 78
    val isBlessed = true
    val isImmortal = false

    //Aura
    val auraVisible = isBlessed && healthPoint > 50 || isImmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"
    println(auraColor)


    val healthStatus = if (healthPoint == 100) "is in excellent condition!"
    else if (healthPoint in 90..99) "has a few scratches."
    else if (healthPoint in 75..89)
        if (isBlessed) "has some minor wounds is healing quite quickly!"
        else "has some minor wounds."
    else if (healthPoint in 15..74) "looks pretty hurts."
    else "is in awful condition!"
    println("$name $healthStatus")

}