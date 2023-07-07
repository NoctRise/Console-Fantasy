package classes

import java.lang.Exception

class Inventar {
    var inventarItems = mutableListOf<Item>( )


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