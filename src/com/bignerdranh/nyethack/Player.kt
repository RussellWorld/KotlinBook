package com.bignerdranh.nyethack

import java.io.File

class Player(
    name: String,
    var blessed: Boolean,
    var healthPoint: Int = 100,
    var immortal: Boolean
) {
    var name = name
        get() = "${field.capitalize()} of $homeTown"
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

    private val homeTown by lazy { selectHometown() }
    var currentPosition = Coordinate(0,0)

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


    private fun selectHometown() = File("data/towns.txt")
        .readText()
        .split("|")
        .shuffled()
        .first()
}