package classes.character.held

import classes.Skill
import classes.character.Character
import classes.character.gegner.Gegner
import classes.utils.getUserInput

open class Held(name: String) : Character(name) {

    protected var klasse: String = "Held"
    protected var skillListe = mutableListOf<Skill>()

    fun printSkills() {
        skillListe.indices.forEach {
            println("[${it + 1}] ${skillListe[it].name}")
        }
    }

    fun chooseSkill(): Skill {
        printSkills()
        println("Welchen Skill willst du einsetzen?")
        return skillListe[getUserInput(max = skillListe.size) - 1]
    }

    open fun useATKSkill(skill: Skill, gegner: Gegner) {}
    open fun useATKSKill(skill: Skill, gegnerListe: List<Gegner>) {}

    open fun useAllySkill(skill: Skill, held: Held) {}


    override fun toString(): String {
        return "${this.name} [${this.klasse}]: ${this.currentHP}HP/${this.maxHP}HP"
    }



}