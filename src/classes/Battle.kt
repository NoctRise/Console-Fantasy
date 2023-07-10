package classes

import classes.character.Team
import classes.character.gegner.Gegner
import classes.character.held.Held
import classes.utils.toGegnerList
import classes.utils.toHeldList

class Battle(private var heldenTeam: Team, private var gegnerTeam: Team) {

    private var runde = 1

    fun startBattle() {
        println("-Kampf startet-\n")
        printTeamHP()

        while (!heldenTeam.isTeamDead() && !gegnerTeam.isTeamDead()) {

            turn()
        }
    }

    private fun turn() {
        printRunde()

        var attackerTeam = heldenTeam
        var defenderTeam = gegnerTeam

        repeat(2) {
            for (attacker in attackerTeam.getTeam()) {
                if (!defenderTeam.isTeamDead()) {
                    if (attacker.isAlive()) {
                        println("${attacker.name} ist an der Reihe.\n")

                        when (attacker) {
                            is Held -> attacker.attack(toGegnerList(defenderTeam.getTeam()))
                            is Gegner -> attacker.attack(toHeldList(defenderTeam.getTeam()))
                            else -> throw Exception("Es können nur Helden oder Gegner angreifen")
                        }

                    } else
                        continue
                } else {
                    break
                }
            }
            attackerTeam = defenderTeam.also { defenderTeam = attackerTeam }
            printTeamHP()
            printWinner()
        }


    }

    private fun printTeamHP() {
        println("-Helden-")
        heldenTeam.printTeamHP()

        println("\n-Gegner-")
        gegnerTeam.printTeamHP()
        println()
    }

    private fun printRunde() {
        println("Runde $runde beginnt.")
        runde++
    }

    fun printWinner() {
        when {
            heldenTeam.isTeamDead() -> println("Game Over.")
            gegnerTeam.isTeamDead() -> println("Sieg!")
        }
    }
}