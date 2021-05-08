package com.bignerdranh.nyethack

open class Room(val name: String) {
    protected open val dangerLevel = 5
    fun description() = "Room: $name"

    open fun load() = "Nothing much to see here..."
}

class TownSquare : Room("Town Square") {
    private val belsound = "GONG!"
    override val dangerLevel = super.dangerLevel - 3
    final override fun load() = "The villagers rally and cheer as you enter!\n${ringBell()}"
    private fun ringBell() = "The bell tower announces your arrival.  $belsound"
}