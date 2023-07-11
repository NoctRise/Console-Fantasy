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

    fun teamBeitreten(character: Character) {
        if (!isFull())
            teamMitglieder.add(character)
        else
            throw Exception("Gegnerteam kann nur aus $maxMitglieder Mitgliedern bestehen!")
    }

    fun isFull() = teamMitglieder.size == maxMitglieder


    fun isTeamDead(): Boolean {
        teamMitglieder.forEach {
            if (it.isAlive())
                return false
        }
        return true
    }

    fun printTeamHP() {
        teamMitglieder.forEach {
            println(it)
        }
    }

    fun chooseGegner(): Gegner {
        println("Wähle Gegner:")
        val gegner = getGegnerTeam().filter { it.isAlive() }
        gegner.indices.forEach {
            println("[${it + 1}] ${gegner[it].name} ")
        }

        return gegner[getUserInput(max = gegner.size) - 1]
    }

    fun getGegnerTeam(): MutableList<Gegner> {
        val gegnerList = mutableListOf<Gegner>()
        teamMitglieder.forEach {
            gegnerList.add(it as Gegner)
        }
        return gegnerList
    }

    fun attack(heldenTeam: HeldenTeam) {

        for (gegner in getGegnerTeam()) {
            if (!heldenTeam.isTeamDead()) {
                if (gegner.isAlive()) {
                    println("${gegner.name} ist an der Reihe.\n")
                    gegner.attack((heldenTeam.getHeldenTeam().filter { it.isAlive() }), this)
                    Thread.sleep(1000)

                } else
                    continue
            } else {
                break
            }
        }
    }
}

