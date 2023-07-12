package classes.character

import classes.character.gegner.Gegner
import classes.character.held.HeldenTeam
import classes.utils.getUserInput


open class Team() {
    protected var teamMitglieder = mutableListOf<Character>()
    protected var maxMitglieder = 6


    constructor(teamListe: MutableList<Character>) : this() {
        if (teamListe.size <= maxMitglieder)
            this.teamMitglieder = teamListe
        else
            throw Exception("Gegnerteam kann nur aus $maxMitglieder Mitgliedern bestehen!")
    }

    // Lässt Charakter das Team beitreten
    fun teamBeitreten(character: Character) {
        // Wenn das Team nicht voll ist, füge den Character ein
        if (!isFull())
            teamMitglieder.add(character)
        else
            println("Gegnerteam kann nur aus $maxMitglieder Mitgliedern bestehen!")
    }

    // Prüft, ob das Team voll ist
    fun isFull() = teamMitglieder.size == maxMitglieder

    // Prüft, ob das gesamte Team tot ist
    fun isTeamDead(): Boolean {
        // Gehe Liste durch und gibt false aus, wenn einer am Leben ist
        teamMitglieder.forEach {
            if (it.isAlive())
                return false
        }
        return true
    }

    // Printet die HP der Teammitglieder aus
    fun printTeamHP() {
        teamMitglieder.forEach {
            println(it)
        }
    }

    // lässt den User einen Gegner wählen
    fun chooseGegner(): Gegner {
        println("Wähle Gegner:")
        val gegner = getGegnerTeam().filter { it.isAlive() }
        gegner.indices.forEach {
            println("[${it + 1}] ${gegner[it]} ")
        }

        return gegner[getUserInput(max = gegner.size) - 1]
    }

    // gibt die Teammitglieder als MutableList<Gegner> zurück
    fun getGegnerTeam(): MutableList<Gegner> {
        val gegnerList = mutableListOf<Gegner>()
        teamMitglieder.forEach {
            gegnerList.add(it as Gegner)
        }
        return gegnerList
    }

    // greift ein Heldenteam an
    fun attack(heldenTeam: HeldenTeam) {

        val gegnerListe = getGegnerTeam().filter { it.isAlive() }
        // Iteriere durch die Gegnerliste
        for (gegner in gegnerListe) {

            // Wenn das Heldenteam noch nicht tot ist, greife an
            if (!heldenTeam.isTeamDead()) {
                // Wenn der derzeitige Gegner (Angreifer) am Leben ist, greife einen Helden an
                println("${gegner.name} ist an der Reihe.\n")

                //greife einen lebenden Helden an
                gegner.attack((heldenTeam.getHeldenTeam().filter { it.isAlive() }), this)
                Thread.sleep(1000)

            } else {
                // Wenn das Heldenteam tot ist, beende Schleife
                break
            }
        }
    }
}

