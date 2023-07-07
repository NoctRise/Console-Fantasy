package classes.character.held

import classes.character.Character
import classes.character.gegner.Gegner

open class Held(name: String) : Character(name) {

    open fun attack(gegnerListe: List<Gegner>) {}

}