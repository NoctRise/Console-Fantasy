package classes.character

open class Boss(name: String) : Gegner(name) {

    init {
        this.currentHP = 2000
        this.maxHP = currentHP
        this.critChance = 10
        this.physischeResistenz = 20
        this.magischeResistenz = 20
        this.strength = 200
        this.intelligence = 100
    }

}