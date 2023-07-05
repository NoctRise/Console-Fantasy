package classes.character

import kotlin.math.absoluteValue

open class Character(var name: String) {

    var currentHP = 500
        set(value) {
            field =
                if (field < 0)
                    0
                else value
        }

    var maxHP = currentHP
    var critChance = 5
    var physischeResistenz = 10
    var magischeResistenz = 10
    var strength = 1
    var intelligence = 1

    fun criticalHit(schaden: Int): Int {

        return if ((1..100).random() <= this.critChance) {
            println("Kritischer Treffer!")
            schaden * 2
        } else
            schaden
    }

    fun isAlive() = currentHP > 0

    open fun turn() = println("${this.name} ist an der Reihe.\n")

    fun takeDmg(dmg: Int) = currentHP - dmg
    fun heal(hp: Int) = currentHP + hp


}