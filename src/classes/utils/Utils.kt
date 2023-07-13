package classes.utils

import classes.character.Character
import classes.character.Team
import classes.character.gegner.Bahamut
import classes.character.held.*
import classes.misc.*
import enums.SkillType
import kotlin.system.exitProcess

// Gibt das Hauptmenü aus
fun hauptMenue() {
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

    println(
        """
        [1] Spiel starten
        [2] Spiel beenden""".trimIndent()
    )

    when (getUserInput(max = 2)) {
        1 -> startGame()

        2 -> {
            println("Spiel wird beendet..")
            exitProcess(0)
        }
    }
}

// Erstellt Teams und startet das Game
fun startGame() {
    var heldenTeam = HeldenTeam()
    println(
        """
           Wähle dein Team         
           [1] Ausgeglichenes Team (Dunkelritter, Schwarzmagier, Weissmagier)
           [2] Eigenes Team
            """.trimIndent()
    )


    when (getUserInput(max = 2)) {
        1 -> {
            println("Ausgeglichenes Team erstellt.")
            heldenTeam = getBalancedTeam()
        }

        2 -> heldenTeam = createTeam()
    }

    // Füge Inventaritems hinzu
    heldenTeam.inventar = Inventar(
        mutableListOf(
            Potion("Heiltrank", 3),
            Potion("Allheilmittel", 3),
            Potion("Stärkungstrank", 1),
            Potion("Intelligenztrank", 1)
        )
    )

    val gegnerTeam = Team(
        mutableListOf(
            Bahamut()
        )
    )
    Thread.sleep(1000)
    repeat(5)
    { println() }


    val battle = Battle(heldenTeam, gegnerTeam)
    battle.startBattle()
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
        print(red)
        println("Kritischer Treffer!")
        print(reset)
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

    print("Eingabe: ")

    do {
        try {
            eingabe = readln().toInt()

            if (eingabe !in min..max)
                throw Exception("Falsche Eingabe")

        } catch (e: Exception) {
            println("Nur Eingaben von $min-$max sind erlaubt.")
        }
    } while (eingabe !in (min..max))
    println()
    return eingabe
}

// Erstellt ein Heldenteam
fun createTeam(): HeldenTeam {
    val heldenTeam = HeldenTeam()
    val charListe = listOf(DunkelRitter(), SchwarzMagier(), WeissMagier())
    var count = 3

    repeat(3)
    {

        println("Wähle eine Klasse für dein Team aus (noch $count übrig)\n")

        charListe.indices.forEach {
            val klasse = charListe[it].klasse.padEnd(14)
            print("[${it + 1}] $klasse")
            charListe[it].printInfo()
        }

        val index = getUserInput(1, 3)

        when (index) {
            1 -> heldenTeam.teamBeitreten(DunkelRitter())
            2 -> heldenTeam.teamBeitreten(SchwarzMagier())
            3 -> heldenTeam.teamBeitreten(WeissMagier())
        }
        count--
    }
    println("Team wurde erstellt.")
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

// Farbcodes
val reset = "\u001b[0m"
val red = "\u001b[0;31m"
val green = "\u001b[0;32m"
