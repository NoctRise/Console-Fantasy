package classes.character.held

import classes.Inventar
import classes.Potion
import classes.character.Character
import classes.character.Team
import classes.utils.getUserInput
import enums.SkillTargeted

open class HeldenTeam() : Team() {

    var inventar: Inventar

    init {
        this.maxMitglieder = 4
        this.inventar = Inventar(
            mutableListOf(
                Potion("Heiltrank", 3),
                Potion("Stärkungstrank", 1),
                Potion("Intelligenztrank", 2)

            )
        )
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


    fun choooseHeld(): Held {
        println("Wähle Held:")
        val heldTeam = getHeldenTeam().filter { it.isAlive() }
        heldTeam.indices.forEach {
            print("[${it + 1}] ${heldTeam[it]}\n")
        }

        return heldTeam[getUserInput(max = heldTeam.size) - 1]
    }

    fun getHeldenTeam(): MutableList<Held> {
        val heldList = mutableListOf<Held>()
        teamMitglieder.forEach {
            heldList.add(it as Held)
        }
        return heldList
    }

    fun attack(gegnerTeam: Team) {

        for (held in getHeldenTeam()) {
            if (!gegnerTeam.isTeamDead()) {
                if (held.isAlive()) {
                    println("\n${held.name} ist an der Reihe.\n")
                    var eingabe = 1

                    if (inventar.inventarItems.size > 0) {
                        println("[1] Angriff\n[2] Inventar")
                        eingabe = getUserInput(max = 2)
                    }


                    when (eingabe) {
                        1 -> {
                            val skill = held.chooseSkill()

                            if (skill.skillTargeted == SkillTargeted.ENEMY) {

                                if (!skill.isAoe) {

                                    if (gegnerTeam.getGegnerTeam().size > 1) {

                                        held.useATKSkill(skill, gegnerTeam.chooseGegner())

                                    } else {
                                        held.useATKSkill(skill, gegnerTeam.getGegnerTeam().first())
                                    }

                                } else {
                                    held.useATKSKill(skill, gegnerTeam.getGegnerTeam())
                                }

                            } else if (skill.skillTargeted == SkillTargeted.ALLY) {
                                held.useAllySkill(skill, choooseHeld())
                            }
                            println()
                        }

                        2 -> {
                            val item = inventar.chooseInventarItems()
                            item.useItem(choooseHeld())
                        }
                    }


                } else
                    continue
            } else {
                break
            }
        }

    }


}

