package classes.character.held

import classes.misc.Skill
import classes.character.gegner.Gegner
import classes.utils.getRandomName
import classes.utils.printDPSSkillLog

class SchwarzMagier(name: String = getRandomName()) : Held(name) {


    init {
        this.maxHP = 650
        this.currentHP = maxHP
        this.critChance = 25
        this.defense = 5
        this.magicDefense = 30
        this.strength = 20
        this.intelligence = 175
        this.klasse = "Schwarzmagier"
        this.skillListe = mutableListOf(
            Skill("Stockhieb"),
            Skill("Feuerball"),
            Skill("Eissturm"),
            Skill("Ultima")
        )

    }


    override fun useATKSkill(skill: Skill, gegner: Gegner) {
        when (skill.name) {
            "Stockhieb" -> stockHieb(gegner)
            "Feuerball" -> feuerBall(gegner)
            "Eissturm" -> eisSturm(gegner)
            "Ultima" -> ultima(gegner)
            else -> println("Besitzt diesen Skill nicht")
        }

    }

    fun stockHieb(gegner: Gegner) {
        printDPSSkillLog(this, gegner, skillListe[0])
    }

    fun feuerBall(gegner: Gegner) {
        printDPSSkillLog(this, gegner, skillListe[1])
    }

    fun eisSturm(gegner: Gegner) {
        printDPSSkillLog(this, gegner, skillListe[2])
    }

    fun ultima(gegner: Gegner) {
        printDPSSkillLog(this, gegner, skillListe[3])
    }
}