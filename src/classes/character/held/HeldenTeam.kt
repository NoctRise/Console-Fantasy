package classes.character.held

import classes.misc.Inventar
import classes.character.Character
import classes.character.Team
import classes.misc.Skill
import classes.utils.getUserInput
import enums.SkillTargeted

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
                    if (held.isPoisoned) {

                        val poisonDmg = (held.maxHP * (Skill("Poison Strike").skillValue / 100.0)).toInt()
                        println("${held.name} nimmt $poisonDmg Schaden wegen Poison.")

                        held.takeDmg(poisonDmg)
                        println(held)

                        if (!held.isAlive())
                            continue
                    }

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
                                    gegnerTeam.getGegnerTeam().filter { it.isAlive() }.forEach {
                                        held.useATKSkill(skill, it)
                                    }
                                }

                            } else if (skill.skillTargeted == SkillTargeted.ALLY) {
                                if (getHeldenTeam().size > 1)
                                    held.useAllySkill(skill, choooseHeld())
                                else
                                    held.useAllySkill(skill, held)
                            }
                            println()
                        }

                        2 -> {
                            val item = inventar.chooseInventarItems()
                            if (getHeldenTeam().filter { it.isAlive() }.size > 1)
                                item.useItem(choooseHeld())
                            else
                                item.useItem(held)
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

