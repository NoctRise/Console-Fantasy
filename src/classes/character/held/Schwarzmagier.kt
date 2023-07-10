package classes.character.held

import classes.character.gegner.Gegner
import classes.utils.chooseEnemy
import classes.utils.getUserInput

class Schwarzmagier(name: String) : Held(name) {


    init {
        this.maxHP = 650
        this.currentHP = maxHP
        this.critChance = 25
        this.defense = 5
        this.magicDefense = 30
        this.strength = 20
        this.intelligence = 175
        this.klasse = "Schwarzmagier"
    }

    override fun attack(gegnerListe: List<Gegner>) {

        println(
            """
            [1] Stockhieb 
            [2] Feuerball 
            [3] Eissturm 
            [4] Ultima 
            
        """.trimIndent()
        )

        val skill = getUserInput(max = 4)
        val target =
            if (gegnerListe.size > 1 && skill != 4) {
                chooseEnemy(gegnerListe)
            } else {
                gegnerListe.first()
            }

        when (skill) {
            1 -> stockHieb(target)
            2 -> feuerBall(target)
            3 -> eisSturm(target)
            4 -> ultima(gegnerListe)
        }
        Thread.sleep(1000)
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