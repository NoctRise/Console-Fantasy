package classes.character.held

import classes.misc.Skill
import classes.character.gegner.Gegner
import classes.utils.getRandomName
import classes.utils.printDPSSkillLog

class DunkelRitter(name: String = getRandomName()) : Held(name) {

    init {
        this.maxHP = 800
        this.currentHP = maxHP
        this.critChance = 20
        this.defense = 30
        this.magicDefense = 5
        this.strength = 150
        this.intelligence = 20
        this.klasse = "Dunkelritter"
        this.skillListe = mutableListOf(
            Skill("Shield"),
            Skill("Chaosklinge"),
            Skill("Doppelklinge"),
            Skill("Excalibur")
        )
    }


    override fun useATKSkill(skill: Skill, gegner: Gegner) {
        when (skill.name) {
            "Chaosklinge" -> chaosklinge(gegner)
            "Doppelklinge" -> doppeltKlinge(gegner)
            "Excalibur" -> excalibur(gegner)
            else -> println("Besitzt diesen Skill nicht")
        }

    }

    override fun useAllySkill(skill: Skill, held: Held) {
        when (skill.name) {
            "Shield" -> shield(held)
        }
        Thread.sleep(1500)
    }

    fun shield(held: Held) {
        held.hasShield = true
        if (held.name == this.name) {
            println("${this.name} setzt Shield ein.")
        } else
            println("${this.name} setzt Shield auf ${held.name} ein.")
    }

    fun chaosklinge(gegner: Gegner) {
        printDPSSkillLog(this, gegner, skillListe[1])
    }


    fun doppeltKlinge(gegner: Gegner) {
        printDPSSkillLog(this, gegner, skillListe[2])
    }

    fun excalibur(gegner: Gegner) {
        printDPSSkillLog(this, gegner, skillListe[3])
    }
}