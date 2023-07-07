package classes.utils

import classes.character.held.HeldenTeam
import classes.character.Character
import classes.character.gegner.Gegner
import classes.character.held.Krieger
import classes.character.held.Schwarzmagier
import classes.character.held.Weissmagier
import java.util.logging.Logger

fun calculateDmg(attacker: Character, defender: Character): Int {
    val schaden = ((100 * (attacker.strength / 100.0)) * ((100 - defender.defense) / 100.0)).toInt()

    return if ((1..100).random() <= attacker.critChance) {
        println("Kritischer Treffer!")
        schaden * 2
    } else
        schaden
}

fun printSkillLog(attacker: Character, defender: Character) {
    println("${attacker.name} setzt Stockhieb auf ${defender.name} ein!")

    Thread.sleep(1000)

    val dmg = calculateDmg(attacker, defender)

    println("${attacker.name} fügt ${defender.name} $dmg Schaden ein.\n")

    defender.takeDmg(dmg)
}


fun getUserInput(min: Int = 1, max: Int): Int {
    var eingabe = 0

    do {
        try {
            eingabe = readln().toInt()

            if (eingabe !in min..max)
                throw Exception("Falsche Eingabe")

        } catch (e: Exception) {
            println("Nur Eingaben von $min-$max sind erlaubt.")
        }
    } while (eingabe !in (min..max))
    return eingabe
}

fun createTeam(): HeldenTeam {
    val heldenTeam = HeldenTeam()
    val charListe = listOf("Krieger", "Schwarzmagier", "Weissmagier")

    repeat(3)
    {

        println("Welche Klasse soll dem Team hinzugefügt werden?\n")

        charListe.indices.forEach {
            println("[${it + 1}] ${charListe[it]}")
        }

        val index = getUserInput(1, 3)

        when (index) {
            1 -> heldenTeam.teamBeitreten(Krieger("Tidus"))
            2 -> heldenTeam.teamBeitreten(Schwarzmagier("Lulu"))
            3 -> heldenTeam.teamBeitreten(Weissmagier("Yuna"))
        }
        println("${charListe[index - 1]} erfolgreich erstellt.\n")
    }
    return heldenTeam
}

fun chooseEnemy(gegner: List<Gegner>): Gegner {
    println("Welchen Gegner möchtest du angreifen?")
    gegner.indices.forEach {
        println("[${it + 1}] ${gegner[it].name}")
    }
    return gegner[getUserInput(max = gegner.size) - 1]
}
