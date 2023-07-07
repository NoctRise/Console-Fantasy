package classes

import classes.character.gegner.GegnerTeam
import classes.character.held.HeldenTeam

class Battle(private var heldenTeam: HeldenTeam, private var gegnerTeam: GegnerTeam) {


    fun startBattle() {
        println("-Kampf startet-\n")
        printTeamHP()

        while (!heldenTeam.isTeamDead() && !gegnerTeam.isTeamDead()) {

            for (held in heldenTeam.teamMitglieder) {
                if (!gegnerTeam.isTeamDead()) {
                    if (held.isAlive()) {
                        println("${held.name} ist an der Reihe.")
                        held.attack(gegnerTeam.teamMitglieder)
                        printTeamHP()
                    } else
                        continue
                } else
                    break
            }



            if (gegnerTeam.isTeamDead()) {
                println("Alle Gegner wurden bezwungen!")
                break
            }

            for (gegner in gegnerTeam.teamMitglieder) {
                if (!heldenTeam.isTeamDead()) {

                    if (gegner.isAlive()) {
                        println("${gegner.name} ist an der Reihe.")
                        gegner.attack(heldenTeam.teamMitglieder)
                    } else
                        continue

                } else
                    break
            }

            printTeamHP()

            if (heldenTeam.isTeamDead()) {
                println("Game Over!")
                break
            }
        }

    }

    private fun printTeamHP() {
        println("Helden")
        heldenTeam.teamMitglieder.forEach { it.printHP() }

        println("\nGegner")
        gegnerTeam.teamMitglieder.forEach { it.printHP() }
        println()
    }


}