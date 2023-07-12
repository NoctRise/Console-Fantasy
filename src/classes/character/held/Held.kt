package classes.character.held

import classes.misc.Skill
import classes.character.Character
import classes.character.gegner.Gegner
import classes.utils.getUserInput

open class Held(name: String) : Character(name) {

    var klasse: String = "Held"


    // lässt den Nutzer einen Skill aus der Skillliste wählen und gibt ihn zurück
    fun chooseSkill(): Skill {
        printSkills()
        println("Welchen Skill willst du einsetzen?")
        return skillListe[getUserInput(max = skillListe.size) - 1]
    }

    //wird genutzt, um Angriffsskills einzusetzen
    open fun useATKSkill(skill: Skill, gegner: Gegner) {}

    //wird genutzt, um Hilfsskills einzusetzen
    open fun useAllySkill(skill: Skill, held: Held) {}


    // Fügt der toString Methode die Klasse des Helden hinzu
    override fun toString(): String {


        return super.toString().replace(":", " [${this.klasse}]:")
    }


}