package classes.misc

import classes.character.Team
import classes.character.held.HeldenTeam
import classes.utils.green
import classes.utils.red
import classes.utils.reset

class Battle(private var heldenTeam: HeldenTeam, private var gegnerTeam: Team) {

    private var runde = 1

    // startet den Kampf
    fun startBattle() {
        println("-Kampf startet-\n")
        printTeamHP()

        // Solange beide Teams am Leben sind, lass sie kämpfen
        while (!heldenTeam.isTeamDead() && !gegnerTeam.isTeamDead()) {

            // Führe ein Kampfrunde aus
            round()
        }
        printWinner()
    }

    private fun round() {
        printRunde()
        // Beide Teams greifen an
        heldenTeam.attack(gegnerTeam)
        gegnerTeam.attack(heldenTeam)
        println("---------------------------------------------------\n")

        // printe die TeamHP aus
        printTeamHP()

    }

    // printe die TeamHP beider Teams aus
    private fun printTeamHP() {
        println("-Helden-")
        heldenTeam.printTeamHP()

        println("\n-Gegner-")
        gegnerTeam.printTeamHP()
        println()
    }

    // printe die derzeitige Runde aus
    private fun printRunde() {
        println("- Runde $runde -")
        runde++
    }

    // Gib den Sieg aus des Teams aus
    fun printWinner() {
        when {
            heldenTeam.isTeamDead() -> println("${red}Game Over.$reset")
            gegnerTeam.isTeamDead() -> println("${green}You won.$reset")
        }
    }
}