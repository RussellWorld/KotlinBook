fun main() {

    val player = Player()
    player.castFireball(4)
    //Аура
    player.auraColor()
    //Состояние игрока
    printPlayerStatus(player)

}


private fun printPlayerStatus(player: Player) {
    println("(Aura: ${player.auraColor()})  (Blessed: ${if (player.isBlessed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus()}")
}







