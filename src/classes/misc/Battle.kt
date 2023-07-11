package classes.misc

import classes.character.Team
import classes.character.held.HeldenTeam

class Battle(private var heldenTeam: HeldenTeam, private var gegnerTeam: Team) {

    private var runde = 1

    fun startBattle() {
        println("-Kampf startet-\n")
        printTeamHP()

        while (!heldenTeam.isTeamDead() && !gegnerTeam.isTeamDead()) {

            turn()
        }
        printWinner()
    }

    private fun turn() {
        printRunde()

        heldenTeam.attack(gegnerTeam)
        gegnerTeam.attack(heldenTeam)
        println("---------------------------------------------\n")

        printTeamHP()

    }

    private fun printTeamHP() {
        println("-Helden-")
        heldenTeam.printTeamHP()

        println("\n-Gegner-")
        gegnerTeam.printTeamHP()
        println()
    }

    private fun printRunde() {
        println("- Runde $runde -")
        runde++
    }

    fun printWinner() {
        when {
            heldenTeam.isTeamDead() -> println("Game Over.")
            gegnerTeam.isTeamDead() -> println("Sieg!")
        }
    }
}