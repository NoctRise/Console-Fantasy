package classes.character

import classes.utils.getUserInput

class Krieger(name: String) : Held(name) {

    init {
        this.critChance = 20
        this.currentHP = 800
        this.maxHP = currentHP
        this.physischeResistenz = 30
        this.magischeResistenz = 5
        this.strength = 150
        this.intelligence = 20
    }

    override fun attack(gegner: List<Gegner>) {
        println(
            """
            [1] Schwerthieb 
            [2] Flammenschwert 
            [3] Excalibur 
            [4] Doppeltklinge 
            
        """.trimIndent()
        )

        val eingabe = getUserInput(max = 4)

        when (eingabe) {
            1 -> schwertHieb(gegner.first())
            2 -> flammenSchwert(gegner.first())
            3 -> excalibur(gegner.first())
            4 -> doppeltKlinge(gegner.first())
        }
        Thread.sleep(1000)

    }


    fun schwertHieb(gegner: Gegner) {
        println("${this.name} setzt Schwerthieb auf ${gegner.name} ein!")

        Thread.sleep(1000)

        val baseDmg = ((100 * (strength / 100.0)) * ((100 - gegner.physischeResistenz) / 100.0)).toInt()

        val finalDmg = criticalHit(baseDmg)

        println("${gegner.name} verliert $finalDmg HP.\n")

        gegner.currentHP -= finalDmg
    }

    fun flammenSchwert(gegner: Gegner) {
        println("${this.name} setzt Flammenschwert auf ${gegner.name} ein!")

        Thread.sleep(1000)

        val baseDmg = ((125 * (intelligence / 100.0)) * ((100 - gegner.magischeResistenz) / 100.0)).toInt()

        val finalDmg = criticalHit(baseDmg)

        println("${gegner.name} verliert $finalDmg HP.\n")

        gegner.currentHP -= finalDmg
    }

    fun excalibur(gegner: Gegner) {
        println("${this.name} setzt Excalibur auf ${gegner.name} ein!")

        Thread.sleep(1000)

        val baseDmg = ((250 * (strength / 100.0)) * ((100 - gegner.physischeResistenz) / 100.0)).toInt()

        val finalDmg = criticalHit(baseDmg)

        println("${gegner.name} verliert $finalDmg HP.\n")

        gegner.currentHP -= finalDmg
    }

    fun doppeltKlinge(gegner: Gegner) {
        println("${this.name} setzt Doppeltklinge auf ${gegner.name} ein!")

        Thread.sleep(1000)

        val baseDmg = ((150 * (strength / 100.0)) * ((100 - gegner.physischeResistenz) / 100.0)).toInt()

        val finalDmg = criticalHit(baseDmg)

        println("${gegner.name} verliert $finalDmg HP.\n")

        gegner.currentHP -= finalDmg
    }


}