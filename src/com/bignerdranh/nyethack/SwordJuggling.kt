package com.bignerdranh.nyethack
import java.lang.Exception

fun main() {
    var swordJuggler: Int? = null
    val isJugglerProficient = (1..3).shuffled().last() == 3
    if (isJugglerProficient) swordJuggler = 2

    try {
        proficiencyCheck(swordJuggler)
        swordJuggler = swordJuggler!!.plus(1)
    } catch (e: Exception) {
        println(e)
    }

    println("You juggle $swordJuggler swords!")
}

fun proficiencyCheck(swordsJuggler: Int?) {
    checkNotNull(swordsJuggler, {"com.bignerdranh.nyethack.Player cannot jugger swords"})
}

fun juggleSword(swordsJuggling: Int){
    require(swordsJuggling >= 3, {" Juggle at least 3 swords to be exciting."})
}

//class UnskilledSwordJuggerException() :
//    IllegalStateException("com.bignerdranh.nyethack.Player cannot juggle swords")