package classes.character.held

import classes.character.gegner.Gegner
import classes.utils.chooseEnemy
import classes.utils.getUserInput

class Krieger(name: String) : Held(name) {

    init {
        this.maxHP = 800
        this.currentHP = maxHP
        this.critChance = 20
        this.defense = 30
        this.magicDefense = 5
        this.strength = 150
        this.intelligence = 20
    }

    override fun attack(gegnerListe: List<Gegner>) {
        println(
            """
            [1] Schwerthieb 
            [2] Flammenschwert 
            [3] Excalibur 
            [4] Doppeltklinge 
            
        """.trimIndent()
        )

        val skill = getUserInput(max = 4)
        val target =
            if (gegnerListe.size > 1) {
                chooseEnemy(gegnerListe)
            } else {
                gegnerListe.first()
            }


        when (skill) {
            1 -> schwertHieb(target)
            2 -> flammenSchwert(target)
            3 -> excalibur(target)
            4 -> doppeltKlinge(target)
        }
        Thread.sleep(1000)

    }


    fun schwertHieb(gegner: Gegner) {
        println("${this.name} setzt Schwerthieb auf ${gegner.name} ein!")

        Thread.sleep(1000)

        val baseDmg = ((100 * (strength / 100.0)) * ((100 - gegner.defense) / 100.0)).toInt()

        val finalDmg = criticalHit(baseDmg)

        println("${gegner.name} verliert $finalDmg HP.\n")

        gegner.takeDmg(finalDmg)
    }

    fun flammenSchwert(gegner: Gegner) {
        println("${this.name} setzt Flammenschwert auf ${gegner.name} ein!")

        Thread.sleep(1000)

        val baseDmg = ((125 * (intelligence / 100.0)) * ((100 - gegner.magicDefense) / 100.0)).toInt()

        val finalDmg = criticalHit(baseDmg)

        println("${gegner.name} verliert $finalDmg HP.\n")

        gegner.takeDmg(finalDmg)
    }

    fun excalibur(gegner: Gegner) {
        println("${this.name} setzt Excalibur auf ${gegner.name} ein!")

        Thread.sleep(1000)

        val baseDmg = ((250 * (strength / 100.0)) * ((100 - gegner.defense) / 100.0)).toInt()

        val finalDmg = criticalHit(baseDmg)

        println("${gegner.name} verliert $finalDmg HP.\n")

        gegner.takeDmg(finalDmg)
    }

    fun doppeltKlinge(gegner: Gegner) {
        println("${this.name} setzt Doppeltklinge auf ${gegner.name} ein!")

        Thread.sleep(1000)

        val baseDmg = ((150 * (strength / 100.0)) * ((100 - gegner.defense) / 100.0)).toInt()

        val finalDmg = criticalHit(baseDmg)

        println("${gegner.name} verliert $finalDmg HP.\n")

        gegner.takeDmg(finalDmg)
    }
}