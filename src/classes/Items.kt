package classes

class Items(var name: String, var anzahl: Int) {
    override fun toString(): String {
        return "${this.name} Anzahl: ${this.anzahl}"
    }
}