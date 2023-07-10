package classes.character.held

import classes.character.gegner.Gegner
import classes.utils.getUserInput

class Weissmagier(name: String) : Held(name) {


    init {
        this.maxHP = 600
        this.currentHP = maxHP
        this.critChance = 5
        this.defense = 15
        this.magicDefense = 15
        this.strength = 15
        this.intelligence = 75
        this.klasse = "Weissmagier"
    }

    override fun attack(gegnerListe: List<Gegner>) {

        println(
            """
            [1] Basic Attack
            [2] Atk Buff 
            [3] Def Buff
            [4] Heal
            
        """.trimIndent()
        )

        val eingabe = getUserInput(max = 4)


    }

    fun basicAttack(gegner: Gegner) {
        println("${this.name} setzt Basic Attack auf ${gegner.name} ein!")

        Thread.sleep(1000)

        val baseDmg = ((90 * (strength / 100.0)) * ((100 - gegner.defense) / 100.0)).toInt()

        val finalDmg = criticalHit(baseDmg)

        println("${gegner.name} verliert $finalDmg HP.\n")

        gegner.takeDmg(finalDmg)
    }

    fun atkBuff(held: Held) {
        println("${this.name} setzt ATK Buff auf ${held.name} ein!")

        Thread.sleep(1000)

        // TODO Buffs erstellen und in Character Attribute implementieren
    }

    fun defBuff(held: Held) {
        println("${this.name} setzt Def Buff auf ${held.name} ein!")

        Thread.sleep(1000)

        // TODO Buffs erstellen und in Character Attribute implementieren
    }



    fun healAllies(held: Held)
    {
        println("${this.name} setzt Heal auf ${held.name} ein!")

        val healAmount = 300

        println("${held.name} wird um $healAmount geheilt")
        held.heal(healAmount)
    }
}