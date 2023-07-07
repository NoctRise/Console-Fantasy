package classes.character.held

import classes.Inventar

open class HeldenTeam() {

    var teamMitglieder = mutableListOf<Held>()
    var maxMitglieder = 4
    var inventar = Inventar()

    constructor(heldenListe: MutableList<Held>) : this() {
        if (heldenListe.size <= maxMitglieder)
            this.teamMitglieder = heldenListe
        else
            throw Exception("Heldenteam kann nur aus $maxMitglieder Mitgliedern bestehen!")
    }

    constructor(heldenListe: MutableList<Held>, inventar: Inventar) : this(heldenListe) {
        this.inventar = inventar
    }


    fun teamBeitreten(held: Held) {
        if (teamMitglieder.size < maxMitglieder)
            teamMitglieder.add(held)
    }

    fun isTeamDead(): Boolean {
        teamMitglieder.forEach {
            if (it.isAlive())
                return false
        }
        return true
    }

    fun printTeam() {
        teamMitglieder.forEach {
            it.printInfo()
        }
    }

    fun useInventory() {
        // TODO
    }
}

