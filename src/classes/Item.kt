package classes

import classes.character.held.Held

open class Item {

    var name: String = ""
    var anzahl: Int = 1
    var beschreibung: String = ""
    var value = 0

    override fun toString(): String {
        return "-${this.name}-\n${this.beschreibung}"
    }

    open fun useItem(held: Held) {}
}