fun main() {
    val name = "Mandrigal"
    var healthPoint = 78
    val isBlessed = true
    val isImmortal = false
    val race = "gnome"

    val faction = when (race) {
        "gnome" -> "Keepers of the Mines"
        "dwarf" -> "Keepers of the Mines"
        "orc" -> "Free People of the Rolling Hills"
        "human" -> "Free People of the Rolling Hills"
        else -> "Error race"
    }

    //Aura
    val auraVisible = isBlessed && healthPoint > 50 || isImmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"

    val healthStatus = when (healthPoint) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75..89 -> if (isBlessed) "has some minor wounds is healing quite quickly!" else "has some minor wounds."
        in 15..74 -> "looks pretty hurts."
        else -> "is in awful condition!"

    }

    println("(Aura: $auraColor Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")

}