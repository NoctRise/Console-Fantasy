package classes.character.held

import classes.misc.Skill
import classes.character.gegner.Gegner
import classes.utils.getRandomName
import classes.utils.printDPSSkillLog

class DunkelRitter(name: String = getRandomName()) : Held(name) {

    // init der Werte
    init {
        this.maxHP = 800
        this.currentHP = maxHP
        this.critChance = 20
        this.defense = 30
        this.magicDefense = 5
        this.strength = 150
        this.intelligence = 20
        this.klasse = "Dunkelritter"

        // fügt Skills hinzu
        this.skillListe = mutableListOf(
            Skill("Shield"),
            Skill("Chaosklinge"),
            Skill("Doppelklinge"),
            Skill("Excalibur")
        )
    }


    // führt anhand der Parameter einen Angriffsskill auf einen Gegner aus
    override fun useATKSkill(skill: Skill, gegner: Gegner) {
        when (skill.name) {
            "Chaosklinge" -> chaosklinge(gegner)
            "Doppelklinge" -> doppeltKlinge(gegner)
            "Excalibur" -> excalibur(gegner)
            else -> println("Besitzt diesen Skill nicht")
        }
    }

    // führt anhand der Parameter einen Hilfsskill auf einen Helden aus
    override fun useAllySkill(skill: Skill, held: Held) {
        when (skill.name) {
            "Shield" -> shield(held)
        }
        Thread.sleep(1500)
    }

    // Skill 1, schützt einen Helden einmalig vor einem Angriff
    fun shield(held: Held) {
        held.hasShield = true
        if (held.name == this.name) {
            println("${this.name} setzt Shield ein.")
        } else
            println("${this.name} setzt Shield auf ${held.name} ein.")
    }

    // Skill 2, greift einen einzelnen Helden mit einem physischen Skill an und printet es aus
    fun chaosklinge(gegner: Gegner) {
        printDPSSkillLog(this, gegner, skillListe[1])
    }

    // Skill 3, greift einen einzelnen Helden mit einem physischen Skill an und printet es aus
    fun doppeltKlinge(gegner: Gegner) {
        printDPSSkillLog(this, gegner, skillListe[2])
    }

    // Skill 4, greift einen einzelnen Helden mit einem physischen Skill an und printet es aus
    fun excalibur(gegner: Gegner) {
        printDPSSkillLog(this, gegner, skillListe[3])
    }
}