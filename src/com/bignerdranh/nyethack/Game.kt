package com.bignerdranh.nyethack

fun main() {

    val player = Player("Bob")
    player.castFireball(4)
    var currentRoom = TownSquare()
    println(currentRoom.description())
    println(currentRoom.load())
    //Состояние игрока
    printPlayerStatus(player)

}


private fun printPlayerStatus(player: Player) {
    println("(Aura: ${player.auraColor()})  (Blessed: ${if (player.blessed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus()}")
}







