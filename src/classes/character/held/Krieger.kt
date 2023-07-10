package classes.character.held

import classes.Skill
import classes.character.gegner.Gegner
import classes.utils.getRandomName

class Krieger(name: String= getRandomName()) : Held(name) {

    init {
        this.maxHP = 800
        this.currentHP = maxHP
        this.critChance = 20
        this.defense = 30
        this.magicDefense = 5
        this.strength = 150
        this.intelligence = 20
        this.klasse = "Krieger"
        this.skillListe = mutableListOf(
            Skill("Flammenschwert"),
            Skill("Chaosklinge"),
            Skill("Doppelklinge"),
            Skill("Excalibur")
        )
    }


    override fun useATKSkill(skill: Skill, gegner: Gegner) {
        when (skill.name) {
            "Chaosklinge" -> chaosklinge(gegner)
            "Flammenschwert" -> flammenSchwert(gegner)
            "Excalibur" -> excalibur(gegner)
            "Doppelklinge" -> doppeltKlinge(gegner)
            else -> println("Besitzt diesen Skill nicht")
        }

    }

    fun chaosklinge(gegner: Gegner) {
        println("${this.name} setzt Chaosklinge auf ${gegner.name} ein!")

        Thread.sleep(1000)

        val baseDmg = ((100 * (strength / 100.0)) * ((100 - gegner.defense) / 100.0)).toInt()

        val finalDmg = criticalHit(baseDmg)

        println("${gegner.name} verliert $finalDmg HP.")

        gegner.takeDmg(finalDmg)
        println(gegner)
    }

    fun flammenSchwert(gegner: Gegner) {
        println("${this.name} setzt Flammenschwert auf ${gegner.name} ein!")

        Thread.sleep(1000)

        val baseDmg = ((150 * (intelligence / 100.0)) * ((100 - gegner.magicDefense) / 100.0)).toInt()

        val finalDmg = criticalHit(baseDmg)

        println("${gegner.name} verliert $finalDmg HP.")

        gegner.takeDmg(finalDmg)
        println(gegner)
    }

    fun excalibur(gegner: Gegner) {
        println("${this.name} setzt Excalibur auf ${gegner.name} ein!")

        Thread.sleep(1000)

        val baseDmg = ((250 * (strength / 100.0)) * ((100 - gegner.defense) / 100.0)).toInt()

        val finalDmg = criticalHit(baseDmg)

        println("${gegner.name} verliert $finalDmg HP.")

        gegner.takeDmg(finalDmg)
        println(gegner)
    }

    fun doppeltKlinge(gegner: Gegner) {
        println("${this.name} setzt Doppeltklinge auf ${gegner.name} ein!")

        Thread.sleep(1000)

        val baseDmg = ((150 * (strength / 100.0)) * ((100 - gegner.defense) / 100.0)).toInt()

        val finalDmg = criticalHit(baseDmg)

        println("${gegner.name} verliert $finalDmg HP.")

        gegner.takeDmg(finalDmg)
        println(gegner)
    }
}