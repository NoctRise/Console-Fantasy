package classes.character.gegner

import classes.character.Character
import classes.character.Team
import classes.character.held.Held

open class Gegner(name: String) : Character(name) {

    // Methode, die Helden angreifen kann
    open fun attack(heldenList: List<Held>, gegnerTeam: Team) {}

}