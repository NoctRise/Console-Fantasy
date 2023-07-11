package classes.character.held

import classes.misc.Skill
import classes.character.Character
import classes.character.gegner.Gegner
import classes.utils.getUserInput

open class Held(name: String) : Character(name) {

    protected var klasse: String = "Held"


    fun chooseSkill(): Skill {
        printSkills()
        println("Welchen Skill willst du einsetzen?")
        return skillListe[getUserInput(max = skillListe.size) - 1]
    }

    open fun useATKSkill(skill: Skill, gegner: Gegner) {}

    open fun useAllySkill(skill: Skill, held: Held) {}


    override fun toString(): String {
        val text = super.toString().split(":")
        val newText = text[0] + " [${this.klasse}]: " + text[1]

        return newText
    }


}