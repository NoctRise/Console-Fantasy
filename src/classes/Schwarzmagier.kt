package classes

class Schwarzmagier(name: String) : Held(name) {

    init {
        this.hp = 650
        this.critChance = 25
        this.physischeResistenz = 5
        this.magischeResistenz = 30
        this.strength = 20
        this.intelligence = 175
    }

    override fun attack(gegner: List<Gegner>) {

        println(
            """
            [1] Stockhieb (physischer single target Skill)
            [2] Feuerball (magischer single target Skill)
            [3] Eissturm (magischer single target Skill)
            [4] Ultima (magischer AOE Skill)
            
        """.trimIndent()
        )
        var eingabe = 0
        try {
            do {
                println("Welchen Skill willst du einsetzen?")
                eingabe = readln().toInt()
            } while (eingabe !in (1..4))
        } catch (e: Exception) {
            println("Nur Eingaben von 1-4 sind erlaubt.")
        }


        when (eingabe) {
            1 -> stockHieb(gegner.first())
            2 -> feuerBall(gegner.first())
            3 -> eisSturm(gegner.first())
            4 -> ultima(gegner)
        }
        Thread.sleep(1000)
    }

    fun stockHieb(gegner: Gegner) {
        println("${this.name} setzt Stockhieb auf ${gegner.name} ein!")

        Thread.sleep(1000)

        /*
        Base Dmg 100
        (strength / 100.0) berechne Multiplikator anhand des Attributs strength
        (100 - gegner.physischeResistenz) / 100.0) berechne Classes.Gegner Resistenz, um Schaden zu verringern
        */
        val baseDmg = ((100 * (strength / 100.0)) * ((100 - gegner.physischeResistenz) / 100.0)).toInt()

        val finalDmg = criticalHit(baseDmg)

        println("${gegner.name} verliert $finalDmg HP.\n")

        gegner.hp -= finalDmg
    }

    fun feuerBall(gegner: Gegner) {
        println("${this.name} setzt Feuerball auf ${gegner.name} ein!")

        Thread.sleep(1000)

        val baseDmg = ((100 * (intelligence / 100.0)) * ((100 - gegner.magischeResistenz) / 100.0)).toInt()

        val finalDmg = criticalHit(baseDmg)

        println("${gegner.name} verliert $finalDmg HP.\n")

        gegner.hp -= finalDmg
    }

    fun eisSturm(gegner: Gegner) {
        println("${this.name} setzt Eissturm auf ${gegner.name} ein!")

        Thread.sleep(1000)

        val baseDmg = ((200 * (intelligence / 100.0)) * ((100 - gegner.magischeResistenz) / 100.0)).toInt()

        val finalDmg = criticalHit(baseDmg)

        println("${gegner.name} verliert $finalDmg HP.\n")

        gegner.hp -= finalDmg
    }

    fun ultima(gegner: List<Gegner>) {
        println("${this.name} setzt Ultima ein!")

        Thread.sleep(1000)

        gegner.forEach {

            val baseDmg = ((350 * (intelligence / 100.0)) * ((100 - it.magischeResistenz) / 100.0)).toInt()
            val finalDmg = criticalHit(baseDmg)

            it.hp -= finalDmg
            println("${it.name} verliert $finalDmg HP.")
            Thread.sleep(1000)
        }
        println()
    }

}