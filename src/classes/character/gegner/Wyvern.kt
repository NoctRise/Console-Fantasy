package classes.character.gegner

import classes.character.Team
import classes.character.held.Held
import classes.misc.Skill
import classes.utils.printDPSSkillLog

class Wyvern(name: String = "Wyvern") : Gegner(name) {

    // init der Werte
    init {
        this.maxHP = 650
        this.currentHP = maxHP
        this.critChance = 7
        this.defense = 10
        this.magicDefense = 10
        this.strength = 140
        this.intelligence = 105

        // fügt Skills hinzu
        this.skillListe = mutableListOf(
            Skill("Biss"),
            Skill("Blizzard"),
            Skill("Eisatem"),
            Skill("Blaue Flamme")
        )
    }

    // Skill 1, greift einen einzelnen Helden mit einem physischen Skill an und printet es aus
    fun biss(held: Held) {
        printDPSSkillLog(this, held, skillListe[0])
    }

    // Skill 2, greift einen einzelnen Helden mit einem magischen Skill an und printet es aus
    fun blizzard(held: Held) {
        printDPSSkillLog(this, held, skillListe[1])
    }

    // Skill 3, greift einen einzelnen Helden mit einem magischen Skill an und printet es aus
    fun eisAtem(held: Held) {
        printDPSSkillLog(this, held, skillListe[2])
    }

    // Skill 4, greift einen einzelnen Helden mit einem magischen Skill an und printet es aus
    fun blaueFlamme(held: Held) {
        printDPSSkillLog(this, held, skillListe[3])
    }


    // lässt Wyvern einen zufälligen Helden angreifen.
    override fun attack(heldenList: List<Held>, gegnerTeam: Team) {
        when ((1..100).random()) {
            in 1..30 -> biss(heldenList.random())
            in 31..50 -> blizzard(heldenList.random())
            in 51..70 -> eisAtem(heldenList.random())
            in 71..100 -> blaueFlamme(heldenList.random())
        }
    }
}