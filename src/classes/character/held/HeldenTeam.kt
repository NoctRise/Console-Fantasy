package classes.character.held

import classes.Inventar
import classes.character.Character
import classes.character.Team

open class HeldenTeam() : Team() {

    var inventar = Inventar()

    init {
        this.maxMitglieder = 4
    }


    constructor(teamListe: MutableList<Character>) : this() {
        if (teamListe.size <= maxMitglieder)
            this.teamMitglieder = teamListe
        else
            throw Exception("Heldenteam kann nur aus $maxMitglieder Mitgliedern bestehen!")
    }

    constructor(heldenListe: MutableList<Character>, inventar: Inventar) : this(heldenListe) {
        this.inventar = inventar
    }


    fun useInventory() {
        // TODO
    }

}

