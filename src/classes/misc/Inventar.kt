package classes.misc

import classes.utils.getUserInput

class Inventar() {
    var inventarItems = mutableListOf<Item>()
        private set

    constructor(inventarItems: MutableList<Item>) : this() {
        this.inventarItems = inventarItems
    }

    // Lässt den User ein Item aussuchen, das zurückgegeben wird
    fun chooseInventarItems(): Item {
        val inventarItemList = inventarItems.filter { it.anzahl > 0 }
        printInventarItems(true)

        println("\nWelches Item möchten sie nutzen?")
        val userInput = getUserInput(max = inventarItemList.size) - 1

        return inventarItemList[userInput]
    }


    // printet die Items aus, true für alle, false für Anzahl >0
    fun printInventarItems(available: Boolean = false) {

        val inventarListe =
            if (available) {
                inventarItems.filter { it.anzahl > 0 }
            } else
                inventarItems

        inventarListe.indices.forEach {
            println("[${it + 1}] ${inventarListe[it].name}, ${inventarListe[it].anzahl} übrig")
        }
    }

    fun hasItemsToUse() = inventarItems.count { it.anzahl > 0 } > 0
}