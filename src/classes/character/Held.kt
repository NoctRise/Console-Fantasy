package classes.character

open class Held(name: String) : Character(name) {

    open fun attack(gegner: List<Gegner>) {}

}