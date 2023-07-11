package classes.misc

import classes.character.held.Held
import enums.Stat

class Potion() : Item() {

    constructor(name: String) : this() {
        when (name) {
            //Inspiriert von Gordon Lucas
            "Heiltrank" -> {
                this.name = name
                this.beschreibung = "Dies ist ein Heiltank, der die verlorene HP heilen kann."
                this.value = 300
            }

            "Stärkungstrank" -> {
                this.name = name
                this.beschreibung = "Dies ist ein Trank, der den physischen Angriff erhöht."
                this.value = 15
            }

            "Intelligenztrank" -> {
                this.name = name
                this.beschreibung = "Dies ist ein Trank, der den magischen Angriff erhöht."
                this.value = 15
            }

            "Allheilmittel" -> {
                this.name = name
                this.beschreibung = "Dies ist ein Trank, welcher fast jeden negativen Zustand entfernt."
            }
        }
    }

    constructor(name: String, anzahl: Int) : this(name) {
        this.anzahl = anzahl

    }

    override fun useItem(held: Held) {
        println("${this.name} wird auf ${held.name} eingesetzt.")
        when (this.name) {
            "Heiltrank" -> {
                held.heal(this.value)
                println("${held.name} wird um ${this.value} geheilt.")
                println(held)
            }

            "Stärkungstrank" -> {
                held.buff(Stat.STRENGTH, this.value)
                println("${held.name}'s Strength steigt um ${this.value}.")
            }

            "Intelligenztrank" -> {
                held.buff(Stat.INTELLIGENCE, this.value)
                println("${held.name}'s Intelligence steigt um ${this.value}.")
            }

            "Allheilmittel" -> {
                held.isPoisoned = false
            }

        }
        this.anzahl--
        Thread.sleep(1500)
    }

}