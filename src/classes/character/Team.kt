package classes.character


open class Team() {
    protected var teamMitglieder = mutableListOf<Character>()
    protected var maxMitglieder = 6


    constructor(teamListe: MutableList<Character>) : this() {
        if (teamListe.size <= maxMitglieder)
            this.teamMitglieder = teamListe
        else
            throw Exception("Gegnerteam kann nur aus $maxMitglieder Mitgliedern bestehen!")
    }

    fun teamBeitreten(character: Character) {
        if (teamMitglieder.size < maxMitglieder)
            teamMitglieder.add(character)
    }

    fun isTeamDead(): Boolean {
        teamMitglieder.forEach {
            if (it.isAlive())
                return false
        }
        return true
    }

    fun printTeamInfo() {
        teamMitglieder.forEach {
            it.printInfo()
        }
    }

    fun printTeamHP() {
        teamMitglieder.forEach {
            println(it)
        }
    }

    fun getTeam(): MutableList<Character> {
        return teamMitglieder
    }

}

