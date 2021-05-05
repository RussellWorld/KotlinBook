import kotlin.math.pow

fun main() {
    val name = "Mandrigal"
    var healthPoint = 78
    val isBlessed = true
    val isImmortal = false
    val race = "gnome"

    //Определение рассы
    whatRace(race)

    //Аура
    val auraColor = auraColor(isBlessed, healthPoint, isImmortal)

    val healthStatus = formatHealthStatus(healthPoint, isBlessed)
    //Состояние игрока
    printPlayerStatus(auraColor, isBlessed, name, healthStatus)

    castFireball(4)

}

private fun whatRace(race: String) {
    val faction = when (race) {
        "gnome" -> "Keepers of the Mines"
        "dwarf" -> "Keepers of the Mines"
        "orc" -> "Free People of the Rolling Hills"
        "human" -> "Free People of the Rolling Hills"
        else -> "Error race"
    }
}

private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String
) {
    println("(Aura: $auraColor Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")
}

private fun auraColor(
    isBlessed: Boolean,
    healthPoint: Int,
    isImmortal: Boolean
): String {
    val auraVisible = isBlessed && healthPoint > 50 || isImmortal
    return if (auraVisible) "GREEN" else "NONE"
}

private fun formatHealthStatus(healthPoint: Int, isBlessed: Boolean) = when (healthPoint) {
    100 -> "is in excellent condition!"
    in 90..99 -> "has a few scratches."
    in 75..89 -> if (isBlessed) "has some minor wounds is healing quite quickly!" else "has some minor wounds."
    in 15..74 -> "looks pretty hurts."
    else -> "is in awful condition!"
}

private fun castFireball(count: Int = 2) {
    val i = count * 7
    val status = when (i) {
        in 1..10 -> "Tipsy"
        in 11..20 -> "Sloshed"
        in 21..30 -> "Soused"
        in 31..40 -> "Stewed"
        else -> "t0st3d"
    }
    println("A glass of Fireball springs into existence. (x$count) (Power: $i) = Status enemy: $status")
}


