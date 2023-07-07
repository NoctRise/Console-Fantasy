package classes.character.gegner

import classes.character.held.Held

class SchwarzDrache(name: String = "Schwarz Drache") : Boss(name) {

    init {
        this.maxHP = 3000
        this.currentHP = maxHP
        this.critChance = 15
        this.defense = 20
        this.magicDefense = 5
        this.strength = 250
        this.intelligence = 150
    }


    fun drachenKlaue(held: Held) {

        println("${this.name} setzt Drachenklaue auf ${held.name} ein!")

        Thread.sleep(1000)

        val baseDmg = ((100 * (strength / 100.0)) * ((100 - held.defense) / 100.0)).toInt()

        val finalDmg = criticalHit(baseDmg)

        println("${held.name} verliert $finalDmg HP.\n")

        held.takeDmg(finalDmg)

    }

    fun feuerAtem(held: Held) {

        println("${this.name} setzt Feueratem auf ${held.name} ein!")

        Thread.sleep(1000)

        val baseDmg = ((100 * (intelligence / 100.0)) * ((100 - held.magicDefense) / 100.0)).toInt()

        val finalDmg = criticalHit(baseDmg)

        println("${held.name} verliert $finalDmg HP.\n")

        held.takeDmg(finalDmg)
    }


    fun schwanzHieb(held: Held) {

        println("${this.name} setzt Schwanzhieb auf ${held.name} ein!")

        Thread.sleep(1000)

        val baseDmg = ((150 * (strength / 100.0)) * ((100 - held.defense) / 100.0)).toInt()

        val finalDmg = criticalHit(baseDmg)

        println("${held.name} verliert $finalDmg HP.\n")

        held.takeDmg(finalDmg)
    }

    fun superNova(heldenList: List<Held>) {
        heldenList.forEach {
            println("${this.name} setzt Super Nova ein!")

            Thread.sleep(1000)


            val baseDmg = ((350 * (intelligence / 100.0)) * ((100 - it.magicDefense) / 100.0)).toInt()
            val finalDmg = criticalHit(baseDmg)

            it.takeDmg(finalDmg)
            println("${it.name} verliert $finalDmg HP.")
            Thread.sleep(1000)

            println()
        }
    }

    override fun attack(gegner: List<Held>) {

        val targetList = gegner.filter { it.isAlive() }

        when ((1..100).random()) {
            in 1..30 -> drachenKlaue(targetList.random())
            in 31..60 -> feuerAtem(targetList.random())
            in 61..89 -> schwanzHieb(targetList.random())
            in 90..100 -> superNova(targetList)
        }
        Thread.sleep(1000)
    }


}