package classes

import java.lang.Exception

class Inventar {
    var inventarItems = mutableListOf<Items>(
        Items("Heiltrank", 5),
        Items("PHY+ Trank", 1),
        Items("MAG+ Trank", 2),

        )


    fun showItemMenu() {
        inventarItems.indices.forEach {
            println("[${it + 1}] ${inventarItems[it]}")
        }
        println("[0] Zurück")

        var eingabe: Int
        try {
            do {
                println("Welches Item möchten sie nutzen?")
                eingabe = readln().toInt()
            } while (eingabe !in inventarItems.indices)
        } catch (e: Exception) {
            println("Es sind nur Eingaben 0-${inventarItems.lastIndex} möglich.")
        }


    }


}