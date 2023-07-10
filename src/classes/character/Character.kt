package classes.character

import enums.Stat


open class Character(var name: String) {

    var maxHP = 500
    var currentHP = maxHP
    var critChance = 5
    var defense = 10
    var magicDefense = 10
    var strength = 1
    var intelligence = 1


    fun isAlive() = currentHP > 0


    fun criticalHit(schaden: Int): Int {

        return if ((1..100).random() <= this.critChance) {
            println("Kritischer Treffer!")
            schaden * 2
        } else
            schaden
    }

    fun takeDmg(dmg: Int) {
        currentHP -= dmg
        if (currentHP < 0)
            currentHP = 0
    }

    fun heal(hp: Int) {
        currentHP += hp
        if (currentHP > maxHP)
            currentHP = maxHP
    }

    fun printInfo() =
        println("${this.name} HP: ${this.maxHP} Str: ${this.strength} Int: ${this.intelligence} Crit: ${this.critChance}% Def: ${this.defense} MagDef: ${this.magicDefense}")


    override fun toString(): String {
        return "${this.name}: ${this.currentHP}HP/${this.maxHP}HP"
    }

    fun buff(stat: Stat, amount: Int) {
        when (stat) {
            Stat.MAXHP -> maxHP += amount
            Stat.CRITCHANCE -> critChance += amount
            Stat.DEFENSE -> defense += amount
            Stat.MAGICDEFENSE -> magicDefense += amount
            Stat.STRENGTH -> strength += amount
            Stat.INTELLIGENCE -> intelligence += amount
        }
    }


    /*fun getMaxHP() = maxHP
        fun getCurrentHP() = currentHP
        fun getCritChance() = critChance
        fun getDefense() = defense
        fun getMagicDefense() = magicDefense
        fun getStrength() = strength
        fun getIntelligence() = intelligence*/
}