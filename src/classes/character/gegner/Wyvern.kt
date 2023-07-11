package classes.character.gegner

import classes.character.Team
import classes.character.held.Held
import classes.misc.Skill
import classes.utils.printDPSSkillLog

class Wyvern(name: String = "Wyvern") : Gegner(name) {
    init {
        this.maxHP = 650
        this.currentHP = maxHP
        this.critChance = 7
        this.defense = 10
        this.magicDefense = 10
        this.strength = 140
        this.intelligence = 105

        this.skillListe = mutableListOf(
            Skill("Biss"),
            Skill("Blizzard"),
            Skill("Eis Atem"),
            Skill("Blaue Flamme")
        )
    }

    fun biss(held: Held) {
        printDPSSkillLog(this, held, skillListe[0])

    }

    fun blizzard(held: Held) {
        printDPSSkillLog(this, held, skillListe[1])
    }

    fun eisAtem(held: Held) {
        printDPSSkillLog(this, held, skillListe[2])
    }

    fun blaueFlamme(held: Held) {
        printDPSSkillLog(this, held, skillListe[3])
    }


    override fun attack(heldenListe: List<Held>, gegnerTeam: Team) {
        when ((1..100).random()) {
            in 1..30 -> biss(heldenListe.random())
            in 31..50 -> blizzard(heldenListe.random())
            in 51..70 -> eisAtem(heldenListe.random())
            in 71..100 -> blaueFlamme(heldenListe.random())
        }
    }
}