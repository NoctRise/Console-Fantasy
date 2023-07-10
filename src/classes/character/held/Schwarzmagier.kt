package classes.character.held

import classes.Skill
import classes.character.gegner.Gegner
import classes.utils.getRandomName

class Schwarzmagier(name: String = getRandomName()) : Held(name) {


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
            else -> println("Besitzt diesen Skill nicht")
        }

    }

    override fun useATKSKill(skill: Skill, gegnerListe: List<Gegner>) {
        when (skill.name) {
            "Ultima" -> ultima(gegnerListe)
            else -> println("Besitzt diesen Skill nicht")
        }
    }

    fun stockHieb(gegner: Gegner) {
        println("${this.name} setzt Stockhieb auf ${gegner.name} ein!")

        Thread.sleep(1000)

        /*
        Base Dmg 100
        (strength / 100.0) berechne Multiplikator anhand des Attributs strength
        (100 - gegner.physischeResistenz) / 100.0) berechne die Gegner Resistenz, um Schaden zu verringern
        */
        val baseDmg = ((100 * (strength / 100.0)) * ((100 - gegner.defense) / 100.0)).toInt()

        val finalDmg = criticalHit(baseDmg)

        println("${gegner.name} verliert $finalDmg HP.")

        gegner.takeDmg(finalDmg)
        println(gegner)
    }

    fun feuerBall(gegner: Gegner) {
        println("${this.name} setzt Feuerball auf ${gegner.name} ein!")

        Thread.sleep(1000)

        val baseDmg = ((100 * (intelligence / 100.0)) * ((100 - gegner.magicDefense) / 100.0)).toInt()

        val finalDmg = criticalHit(baseDmg)

        println("${gegner.name} verliert $finalDmg HP.")

        gegner.takeDmg(finalDmg)
        println(gegner)
    }

    fun eisSturm(gegner: Gegner) {
        println("${this.name} setzt Eissturm auf ${gegner.name} ein!")

        Thread.sleep(1000)

        val baseDmg = ((200 * (intelligence / 100.0)) * ((100 - gegner.magicDefense) / 100.0)).toInt()

        val finalDmg = criticalHit(baseDmg)

        println("${gegner.name} verliert $finalDmg HP.")
        gegner.takeDmg(finalDmg)
        println(gegner)
    }

    fun ultima(gegner: List<Gegner>) {
        println("${this.name} setzt Ultima ein!")

        Thread.sleep(1000)

        gegner.forEach {

            val baseDmg = ((350 * (intelligence / 100.0)) * ((100 - it.magicDefense) / 100.0)).toInt()
            val finalDmg = criticalHit(baseDmg)

            it.takeDmg(finalDmg)
            println("${it.name} verliert $finalDmg HP.")
            println(it)
            Thread.sleep(1000)
            println()
        }
        println()
    }

}