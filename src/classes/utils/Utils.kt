package classes.utils

import classes.misc.Skill
import classes.character.Character
import classes.character.held.*
import enums.SkillType

// Gibt das Hauptmenü aus
fun hauptmenue() {
    println(
        """
   ______                       __        ______            __                  
  / ____/___  ____  _________  / /__     / ____/___ _____  / /_____ ________  __
 / /   / __ \/ __ \/ ___/ __ \/ / _ \   / /_  / __ `/ __ \/ __/ __ `/ ___/ / / /
/ /___/ /_/ / / / (__  ) /_/ / /  __/  / __/ / /_/ / / / / /_/ /_/ (__  ) /_/ / 
\____/\____/_/ /_/____/\____/_/\___/  /_/    \__,_/_/ /_/\__/\__,_/____/\__, /  
                                                                       /____/   


    """.trimIndent()
    )
}

/*
 Berechnet den endgültigen Schaden, der abgezogen wird
 SkillDmg x (Stat / 100)            x             ((100 - defense)/100)
             ^ Dmg erhöhen                          ^ Dmg verrringern
*/
fun calculateDmg(attacker: Character, defender: Character, skill: Skill): Int {
    val schaden =
        if (skill.skillType == SkillType.PHY)
            (skill.skillValue * (attacker.strength / 100.0) * ((100 - defender.defense) / 100.0)).toInt()
        else
            (skill.skillValue * (attacker.intelligence / 100.0) * ((100 - defender.magicDefense) / 100.0)).toInt()

    return if ((1..100).random() <= attacker.critChance) {
        println("Kritischer Treffer!")
        schaden * 2
    } else
        schaden
}

// Printet einen Skilllog aus
fun printDPSSkillLog(attacker: Character, defender: Character, skill: Skill) {

    if (!defender.hasShield) {
        val dmg = calculateDmg(attacker, defender, skill)

        println("${attacker.name} fügt ${defender.name} $dmg Schaden mit ${skill.name} zu.")
        defender.takeDmg(dmg)
        println(defender)
    } else {
        println("${defender.name}'s Shield blockierte ${skill.name} von ${attacker.name} ab.")
        defender.hasShield = false
    }


    println()
    Thread.sleep(1500)
}


// gibt eine Usereingabe zwischen Min und Max zurück
fun getUserInput(min: Int = 1, max: Int): Int {
    var eingabe = -1

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

// Erstellt ein Heldenteam
fun createTeam(): HeldenTeam {
    val heldenTeam = HeldenTeam()
    val charListe = listOf("Dunkelritter", "Schwarzmagier", "Weissmagier")

    repeat(3)
    {

        println("Welche Klasse soll dem Team hinzugefügt werden?\n")

        charListe.indices.forEach {
            println("[${it + 1}] ${charListe[it]}")
        }

        val index = getUserInput(1, 3)

        when (index) {
            1 -> heldenTeam.teamBeitreten(DunkelRitter(getRandomName()))
            2 -> heldenTeam.teamBeitreten(SchwarzMagier(getRandomName()))
            3 -> heldenTeam.teamBeitreten(WeissMagier(getRandomName()))
        }
        println("${charListe[index - 1]} erfolgreich erstellt.\n")
    }
    return heldenTeam
}

// Gibt ein Heldenteam aus allen Klassen zurück
fun getBalancedTeam(): HeldenTeam {
    return HeldenTeam(
        mutableListOf(
            DunkelRitter(getRandomName()),
            SchwarzMagier(getRandomName()),
            WeissMagier(getRandomName())
        )
    )
}


// Gibt einen zufälligen Namen zurück
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