package classes.character.held

import classes.character.gegner.Gegner
import classes.utils.getUserInput

class Weissmagier(name: String) : Held(name) {


    init {
        this.maxHP = 600
        this.currentHP = maxHP
        this.critChance = 5
        this.defense = 15
        this.magicDefense = 15
        this.strength = 15
        this.intelligence = 75
    }

    override fun attack(gegner: List<Gegner>) {

        println(
            """
            [1] Basic Attack
            [2] Atk Buff 
            [3] Mag Atk Buff 
            [4] Heilen
            
        """.trimIndent()
        )

        val eingabe = getUserInput(max = 4)


    }

}