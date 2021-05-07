class Player {
    var name = "mandrigal"
    val isBlessed = true
    private val isImmortal = false
    var healthPoint = 78


    fun auraColor(): String {
        val auraVisible = isBlessed && healthPoint > 50 || isImmortal
        return if (auraVisible) "GREEN" else "NONE"
    }

    fun formatHealthStatus() = when (healthPoint) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75..89 -> if (isBlessed) "has some minor wounds is healing quite quickly!" else "has some minor wounds."
        in 15..74 -> "looks pretty hurts."
        else -> "is in awful condition!"
    }

    fun castFireball(numFireballs: Int = 2) =
        println("A glass of Fireball springs into existence. ($numFireballs")

    fun whatRace(race: String) {
        val faction = when (race) {
            "gnome" -> "Keepers of the Mines"
            "dwarf" -> "Keepers of the Mines"
            "orc" -> "Free People of the Rolling Hills"
            "human" -> "Free People of the Rolling Hills"
            else -> "Error race"
        }
    }
}