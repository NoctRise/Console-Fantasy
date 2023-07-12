package classes.misc

import classes.character.held.Held

open class Item {

    var name: String = ""
        protected set
    var anzahl: Int = 1
        protected set
    var beschreibung: String = ""
        protected set
    var value: Int = 0
        protected set

    init {
        this.name = name
    }

    override fun toString(): String {
        return "-${this.name}-\n${this.beschreibung}"
    }

    open fun useItem(held: Held) {}
}