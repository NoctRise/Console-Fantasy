package classes.character.gegner

import classes.character.Character
import classes.character.Team
import classes.character.held.Held

open class Gegner(name: String) : Character(name) {

    open fun attack(heldenListe: List<Held>, gegnerTeam: Team) {}

}