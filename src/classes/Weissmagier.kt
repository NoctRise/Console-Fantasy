package classes

import classes.Character

class Weissmagier(name: String) : Character(name) {


    init {
        this.critChance = 5
        this.hp = 600
        this.physischeResistenz = 15
        this.magischeResistenz = 15
        this.strength = 15
        this.intelligence = 75
    }
}