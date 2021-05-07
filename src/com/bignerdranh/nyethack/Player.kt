package com.bignerdranh.nyethack

import java.io.File

class Player(
    name: String,
    var blessed: Boolean,
    var healthPoint: Int = 100,
    var immortal: Boolean
) {
    var name = name
        get() = "${field.capitalize()} of $hometown"
        private set(value) {
            field = value.trim()
        }

    constructor(name: String) : this(
        name,
        blessed = true,
        immortal = false
    ) {
        if (name.toLowerCase() == "kar") healthPoint = 40
    }

    init {
        require(healthPoint > 0) { "healthPoints must be greater than zero." }
        require(name.isNotBlank()) { "player must have a name." }
    }

    val hometown by lazy { selectHometown() }

    fun auraColor(): String {
        val auraVisible = blessed && healthPoint > 50 || immortal
        return if (auraVisible) "GREEN" else "NONE"
    }

    fun formatHealthStatus() = when (healthPoint) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75..89 -> if (blessed) "has some minor wounds is healing quite quickly!" else "has some minor wounds."
        in 15..74 -> "looks pretty hurts."
        else -> "is in awful condition!"
    }

    fun castFireball(numFireballs: Int = 2) =
        println("A glass of Fireball springs into existence. ($numFireballs)")

    fun whatRace(race: String) {
        val faction = when (race) {
            "gnome" -> "Keepers of the Mines"
            "dwarf" -> "Keepers of the Mines"
            "orc" -> "Free People of the Rolling Hills"
            "human" -> "Free People of the Rolling Hills"
            else -> "Error race"
        }
    }

    private fun selectHometown() = File("data/towns.txt")
        .readText()
        .split("|")
        .shuffled()
        .first()
}