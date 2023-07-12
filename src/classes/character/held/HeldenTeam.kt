package classes.character.held

import classes.misc.Inventar
import classes.character.Character
import classes.character.Team
import classes.misc.Skill
import classes.utils.getUserInput
import enums.SkillTargeted

open class HeldenTeam() : Team() {

    // Inventar des Heldenteams, was Items enthält
    var inventar = Inventar()

    init {
        // Maximum der Teammitglieder
        this.maxMitglieder = 4
    }

    constructor(teamListe: MutableList<Character>) : this() {
        // Wenn die Elemente der übergebenen Liste unter dem Maximum ist, füge die Helden ins Team hinzu
        if (teamListe.size <= maxMitglieder)
            this.teamMitglieder = teamListe
        else
        // ansonsten wirf eine Exception
            throw Exception("Heldenteam kann nur aus $maxMitglieder Mitgliedern bestehen!")
    }


    constructor(heldenListe: MutableList<Character>, inventar: Inventar) : this(heldenListe) {
        this.inventar = inventar
    }

    //lässt den User einen Helden aus dem Team wählen und gibt diesen zurück
    fun chooseHeld(): Held {
        println("Wähle Held:")
        val heldTeam = getHeldenTeam().filter { it.isAlive() }
        heldTeam.indices.forEach {
            print("[${it + 1}] ${heldTeam[it]}\n")
        }

        return heldTeam[getUserInput(max = heldTeam.size) - 1]
    }

    // gibt die Teammitglieder als MutableList<Held> zurück
    fun getHeldenTeam(): MutableList<Held> {
        val heldList = mutableListOf<Held>()
        teamMitglieder.forEach {
            heldList.add(it as Held)
        }
        return heldList
    }

    // Greift ein anderes Team an
    fun attack(gegnerTeam: Team) {

        // Filter Liste nach überlebenden Helden
        val heldenTeam = getHeldenTeam().filter { it.isAlive() }

        // Iteriert durch das Heldenteam
        for (held in heldenTeam) {

            // Wenn das gegnerische Team am Leben ist, greife an
            if (!gegnerTeam.isTeamDead()) {
                println("\n${held.name} [${held.klasse}] ist an der Reihe.\n")

                // Ist der derzeitige Held vergiftet, erleide prozentualen Schaden
                if (held.isPoisoned) {

                    // erleidet Dmg anhand des Wertes vom Skill 'Poison Strike'
                    val poisonDmg = (held.maxHP * (Skill("Poison Strike").skillValue / 100.0)).toInt()
                    println("${held.name} nimmt $poisonDmg Schaden wegen Poison.")

                    // verringere Held HP
                    held.takeDmg(poisonDmg)

                    // printe Heldenhp
                    println(held)
                    println()

                    // Wenn der Held gestorben ist, überspringe ihn und lasst nicht zum Zug kommen
                    if (!held.isAlive())
                        continue
                }

                var eingabe = 1

                // Wenn sich Items im Inventar befinden, gib dem User die Auswahl zwischen Angreifen und Inventar
                if (inventar.inventarItems.count { it.anzahl > 0 } > 0) {
                    println("[1] Angriff\n[2] Inventar")

                    // Lass den User eine Eingabe machen (Eingabe zwischen 1 und 2)
                    eingabe = getUserInput(max = 2)
                }


                when (eingabe) {
                    // User wählt Angriff
                    1 -> {
                        // Lässt den einen Skill vom Helden auswählen
                        val skill = held.chooseSkill()

                        // Ist der gewählte Skill ein DMG Skill?
                        if (skill.skillTargeted == SkillTargeted.ENEMY) {

                            // Wenn der Skill nicht ein AOE (Flächenschaden) Skill ist, lass den User einen Gegner wählen
                            if (!skill.isAoe) {

                                // Wenn es mehr als 2 Gegner sind, lass den User einen davon aussuchen
                                if (gegnerTeam.getGegnerTeam().count { it.isAlive() } > 1) {

                                    held.useATKSkill(skill, gegnerTeam.chooseGegner())

                                } else {
                                    // ansonsten nimm den ersten Gegner aus der Liste der überlebenden
                                    val gegnerListe = gegnerTeam.getGegnerTeam().filter { it.isAlive() }
                                    held.useATKSkill(skill, gegnerListe.first())
                                }

                            } // Wenn es ein AOE (Flächenschaden) Skill ist, greife jeden der Gegner an
                            else {
                                gegnerTeam.getGegnerTeam().filter { it.isAlive() }.forEach {
                                    held.useATKSkill(skill, it)
                                }
                            }
                            // Ist der eingesetzte Skill ein Hilfsskill?
                        } else if (skill.skillTargeted == SkillTargeted.ALLY) {
                            // Wenn es mehr als 2 Helden im Team gibt, lass den User wählen auf welchen Helden es angewendet wird
                            if (getHeldenTeam().size > 1)
                                held.useAllySkill(skill, chooseHeld())
                            else
                            // setzt den Skill auf sich selbst ein
                                held.useAllySkill(skill, held)
                        }
                        println()
                    }

                    2 -> {
                        // prüft ob das Inventar Items besitzt
                        if (inventar.inventarItems.count { it.anzahl > 0 } > 0) {
                            // Lass den User ein Item wählen, welches nutzen kann
                            val item = inventar.chooseInventarItems()

                            // Wenn es mehr als 1 Held sind, lass den User wählen
                            if (heldenTeam.size > 1)
                                item.useItem(chooseHeld())
                            else
                            //Ansonsten nutzt das Item auf sich selbst
                                item.useItem(held)
                        } else
                        // Wenn der Count 0 ist, wird ausgegeben, dass das Inventar leer ist
                            println("Inventar ist leer")
                    }

                }
            } else {
                // Wenn das Gegnerteam tot ist, brich die Schleife ab
                break
            }
        }
    }
}

