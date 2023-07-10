package classes.character.held

import classes.character.Character
import classes.character.gegner.Gegner

open class Held(name: String) : Character(name) {

    var klasse: String = "Held"
    open fun attack(gegnerListe: List<Gegner>) {}

    override fun toString(): String {
        return "${this.name} [${this.klasse}]: ${this.currentHP}HP/${this.maxHP}HP"
    }

}