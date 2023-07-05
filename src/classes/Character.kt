package classes

open class Character(var name: String) {
    var hp = 500
    var critChance = 5
    var physischeResistenz = 10
    var magischeResistenz = 10
    var strength = 1
    var intelligence = 1

    fun criticalHit(schaden: Int): Int {

        return if ((1..100).random() <= this.critChance) {
            println("Kritischer Treffer!")
            schaden * 2
        } else
            schaden
    }
}