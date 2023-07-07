package classes.character.gegner


class GegnerTeam {
    var teamMitglieder = mutableListOf<Gegner>()
    var maxMitglieder = 4


    constructor(gegnerListe: MutableList<Gegner>) {
        if (gegnerListe.size <= maxMitglieder)
            this.teamMitglieder = gegnerListe
        else
            throw Exception("Gegnerteam kann nur aus $maxMitglieder Mitgliedern bestehen!")
    }

    fun teamBeitreten(gegner: Gegner) {
        if (teamMitglieder.size < maxMitglieder)
            teamMitglieder.add(gegner)
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
}

