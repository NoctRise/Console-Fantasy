package classes.character.gegner

open class Boss(name: String) : Gegner(name) {

    init {
        this.maxHP = 2000
        this.currentHP = maxHP
        this.critChance = 10
        this.defense = 20
        this.magicDefense = 20
        this.strength = 200
        this.intelligence = 100
    }

}