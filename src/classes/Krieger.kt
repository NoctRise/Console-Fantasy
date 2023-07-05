package classes

import classes.Character

class Krieger(name: String) : Character(name) {

    init {
        this.critChance = 20
        this.hp = 800
        this.physischeResistenz = 30
        this.magischeResistenz = 5
        this.strength = 150
        this.intelligence = 20
    }
}