package classes

import classes.utils.getUserInput

class Inventar {
    var inventarItems = mutableListOf<Item>()


    constructor(inventarItems: MutableList<Item>) {
        this.inventarItems = inventarItems
    }

    fun putInItem(item: Item) {
        inventarItems.add(item)
    }

    fun chooseInventarItems(): Item {
        val inventarItems = inventarItems.filter { it.anzahl > 0 }
        inventarItems.indices.forEach {
            println("[${it + 1}] ${inventarItems[it].name}, ${inventarItems[it].anzahl} übrig")
        }

        println("Welches Item möchten sie nutzen?")
        val userInput = getUserInput(max = inventarItems.size) - 1

        return inventarItems[userInput]
    }


}