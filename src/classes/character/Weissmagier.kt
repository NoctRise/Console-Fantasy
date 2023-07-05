package classes.character

class Weissmagier(name: String) : Held(name) {


    init {
        this.critChance = 5
        this.currentHP = 600
        this.maxHP = currentHP
        this.physischeResistenz = 15
        this.magischeResistenz = 15
        this.strength = 15
        this.intelligence = 75
    }
}