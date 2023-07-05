package classes.character

class SchwarzDrache(name: String = "Schwarz Drache") : Boss(name) {

    init {
        this.currentHP = 3000
        this.maxHP = currentHP
        this.critChance = 15
        this.physischeResistenz = 40
        this.magischeResistenz = 5
        this.strength = 250
        this.intelligence = 150
    }


    fun drachenKlaue(held: Held) {

        println("${this.name} setzt Drachenklaue auf ${held.name} ein!")

        Thread.sleep(1000)

        val baseDmg = ((100 * (strength / 100.0)) * ((100 - held.physischeResistenz) / 100.0)).toInt()

        val finalDmg = criticalHit(baseDmg)

        println("${held.name} verliert $finalDmg HP.\n")

        held.currentHP -= finalDmg

    }

    fun feuerAtem(held: Held) {

        println("${this.name} setzt Feueratem auf ${held.name} ein!")

        Thread.sleep(1000)

        val baseDmg = ((100 * (intelligence / 100.0)) * ((100 - held.magischeResistenz) / 100.0)).toInt()

        val finalDmg = criticalHit(baseDmg)

        println("${held.name} verliert $finalDmg HP.\n")

        held.currentHP -= finalDmg
    }


    fun schwanzHieb(held: Held) {

        println("${this.name} setzt Schwanzhieb auf ${held.name} ein!")

        Thread.sleep(1000)

        val baseDmg = ((150 * (strength / 100.0)) * ((100 - held.physischeResistenz) / 100.0)).toInt()

        val finalDmg = criticalHit(baseDmg)

        println("${held.name} verliert $finalDmg HP.\n")

        held.currentHP -= finalDmg
    }

    fun superNova(heldenList: List<Held>) {
        heldenList.forEach {
            println("${this.name} setzt Super Nova ein!")

            Thread.sleep(1000)

            heldenList.forEach {

                val baseDmg = ((350 * (intelligence / 100.0)) * ((100 - it.magischeResistenz) / 100.0)).toInt()
                val finalDmg = criticalHit(baseDmg)

                it.currentHP -= finalDmg
                println("${it.name} verliert $finalDmg HP.")
                Thread.sleep(1000)
            }
            println()
        }
    }

    override fun attack(gegner: List<Held>) {

        when ((1..100).random()) {
            in 1..30 -> drachenKlaue(gegner.random())
            in 31..60 -> feuerAtem(gegner.random())
            in 61..89 -> schwanzHieb(gegner.random())
            in 90..100 -> superNova(gegner)
        }
    }


}