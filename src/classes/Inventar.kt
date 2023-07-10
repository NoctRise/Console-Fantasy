package classes

import classes.utils.getUserInput

class Inventar {
    var inventarItems = mutableListOf<Item>()


    fun showItemMenu() {
        inventarItems.indices.forEach {
            println("[${it + 1}] ${inventarItems[it]}")
        }
        println("[0] Zurück")

        println("Welches Item möchten sie nutzen?")

        val item = getUserInput(max = inventarItems.size)

        // TODO zuende schreiben
    }

    fun useItem()
    {

    }

}