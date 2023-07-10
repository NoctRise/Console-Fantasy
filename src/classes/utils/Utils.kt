package classes.utils

import classes.character.Character
import classes.character.gegner.Gegner
import classes.character.held.*
import java.util.logging.Logger

fun hauptmenue()
{
    println("""
   ______                       __        ______            __                  
  / ____/___  ____  _________  / /__     / ____/___ _____  / /_____ ________  __
 / /   / __ \/ __ \/ ___/ __ \/ / _ \   / /_  / __ `/ __ \/ __/ __ `/ ___/ / / /
/ /___/ /_/ / / / (__  ) /_/ / /  __/  / __/ / /_/ / / / / /_/ /_/ (__  ) /_/ / 
\____/\____/_/ /_/____/\____/_/\___/  /_/    \__,_/_/ /_/\__/\__,_/____/\__, /  
                                                                       /____/   


    """.trimIndent())
}

// TODO finish mit Skill Parameter
fun calculateDmg(attacker: Character, defender: Character): Int {
    val schaden = ((100 * (attacker.strength / 100.0)) * ((100 - defender.defense) / 100.0)).toInt()

    return if ((1..100).random() <= attacker.critChance) {
        println("Kritischer Treffer!")
        schaden * 2
    } else
        schaden
}

// TODO finish mit Skill Parameter
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
            1 -> heldenTeam.teamBeitreten(Krieger(getRandomName()))
            2 -> heldenTeam.teamBeitreten(Schwarzmagier(getRandomName()))
            3 -> heldenTeam.teamBeitreten(Weissmagier(getRandomName()))
        }
        println("${charListe[index - 1]} erfolgreich erstellt.\n")
    }
    return heldenTeam
}

fun getBalancedTeam(): HeldenTeam {
    return HeldenTeam(
        mutableListOf(
            Krieger(getRandomName()),
            Schwarzmagier(getRandomName()),
            Weissmagier(getRandomName())
        )
    )
}


fun chooseEnemy(gegner: List<Gegner>): Gegner {
    println("Welchen Gegner möchtest du angreifen?")
    gegner.indices.forEach {
        println("[${it + 1}] ${gegner[it].name}")
    }
    return gegner[getUserInput(max = gegner.size) - 1]
}

fun toGegnerList(characterList: List<Character>): MutableList<Gegner> {
    val gegnerList = mutableListOf<Gegner>()
    characterList.forEach {
        gegnerList.add(it as Gegner)
    }

    return gegnerList
}

fun toHeldList(characterList: List<Character>): MutableList<Held> {
    val heldenList = mutableListOf<Held>()
    characterList.forEach {
        heldenList.add(it as Held)
    }
    return heldenList
}


fun getRandomName(): String {
    return listOf(
        "Tidus",
        "Yuna",
        "Rikku",
        "Paine",
        "Lightning",
        "Zack",
        "Cloud",
        "Tifa",
        "Noctis",
        "Sephiroth",
        "Aerith",
        "Cindy"
    ).random()
}